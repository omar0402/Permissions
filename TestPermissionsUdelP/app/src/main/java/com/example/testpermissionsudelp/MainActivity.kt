package com.example.testpermissionsudelp

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.testpermissionsudelp.Tools.PermissionsApplication

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 1
    val permission = PermissionsApplication(this@MainActivity)
    val listPermissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!permission.hasPermissions(listPermissions)) {

            permission.requestPermission(listPermissions, REQUEST_CODE)

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when (requestCode){

            REQUEST_CODE -> {

                if(grantResults.size>0){

                    if(grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults [1] != PackageManager.PERMISSION_GRANTED){

                        Toast.makeText(this@MainActivity, "Es obligatorio acptar los permisos para utilizar esta aplicación", Toast.LENGTH_LONG).show()
                        finish()

                    }

                }
                else{

                    Toast.makeText(this@MainActivity, "Esobligatorio aceptar los permisos para utilizar esta aplicación.", Toast.LENGTH_LONG).show()
                    finish()

                }

            }

        }

        /*Log.d("UDELP", requestCode.toString())


        for (p in permissions){

            Log.d("UDELP", p)

        }

        for (gr in grantResults){

            Log.d("UDELP", gr.toString())

        }*/

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

}
