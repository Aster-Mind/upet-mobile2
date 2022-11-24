package com.astermind.upet_mobile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.astermind.upet_mobile.models.LoginCreds
import com.astermind.upet_mobile.models.RolCreds
import com.astermind.upet_mobile.models.idSession
import com.astermind.upet_mobile.models.thisSession
import com.astermind.upet_mobile.services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        // Codigo para pantalla completa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )


        // Declaracion de componentes / Navegacion TODO
        //val Email = findViewById<TextInputLayout>(R.id.outlinedEmail)
        //val Password = findViewById<TextInputLayout>(R.id.outlinedPassword)
        val Login = findViewById<Button>(R.id.gButtonLogin)
        val Restablecer = findViewById<TextView>(R.id.gOlvide)
        val correo = findViewById<EditText>(R.id.gCorreo)
        val pass = findViewById<EditText>(R.id.gPass)



        Log.d("asd", "--------------------------------------------------------"+ correo.text.toString() + pass.text.toString())

        val ctx = this
        Login.setOnClickListener {
            val Credenciales = LoginCreds(correo.text.toString(), pass.text.toString() )
            Login(Credenciales, ctx)
        }
        Restablecer.setOnClickListener {
            Restablecer()
        }

    }

    // Funciones de navegacion
    private fun Login(creds:LoginCreds, context:Context) {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://upetapi.azurewebsites.net/api/")
            .build()
            .create(ApiInterface::class.java)

        val ApiInterface = retrofitBuilder.Login(creds)

        ApiInterface.enqueue(object:Callback<RolCreds>{

            override fun onFailure(call: Call<RolCreds>, t: Throwable) {

                Toast.makeText(context, "Ha ocurrido un error intenta más tarde", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<RolCreds>, response: Response<RolCreds>) {
                val rsp = response.body()

           if(response.message() != "Bad Request" && response.message() != "Not Found"){

               idSession = rsp!!.id
               thisSession = rsp!!
                if(rsp?.rol=="Ong")
                {
                val i = Intent(context, DashBoardScreen::class.java)
                startActivity(i)
                }

               if(rsp?.rol =="User"){
                   val i = Intent(context, HomeScreen::class.java)
                   startActivity(i)
               }
             }else{
                 //Credenciales incorrectas
               Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
           }
            }
        })


    }

    private fun Restablecer() {
        val i = Intent(this, ForgotScreen::class.java)
        startActivity(i)
    }
}