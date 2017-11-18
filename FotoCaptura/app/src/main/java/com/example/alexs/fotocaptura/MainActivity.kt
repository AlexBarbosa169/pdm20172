package com.example.alexs.fotocaptura

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.net.URI
import android.provider.MediaStore.Images
import java.io.ByteArrayOutputStream
import java.io.File


class MainActivity : AppCompatActivity() {

    lateinit var btnCamera: Button
    lateinit var imgCapturada : ImageView
    lateinit var itPhoto : Bundle
    lateinit var btnCompartilhar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btnCompartilhar = findViewById(R.id.btnCompartilhar)
        this.imgCapturada = findViewById(R.id.imgView)
        this.btnCamera = findViewById(R.id.btnAdrirCam)
        this.btnCamera.setOnClickListener({ AbrirCamera(it)})
        this.btnCompartilhar.setOnClickListener({CompartilharFoto(it)})

    }

    private fun CompartilharFoto(it: View?) {

        var itCompartilhamento = Intent(Intent.ACTION_SEND)
        println(itPhoto.toString())

        itCompartilhamento.setType("image/bmp")
        itCompartilhamento.putExtra(Intent.EXTRA_STREAM, itPhoto)

        startActivity(itCompartilhamento)
    }

    fun AbrirCamera(view : View){

        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(it,0)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null){
            if (requestCode == 0) {
//                Retirando e exibindo a imagem
                var extras : Bundle = data.getExtras();
                var imageBitmap : Bitmap = extras.get("data") as Bitmap
                imgCapturada.setImageBitmap(imageBitmap);
                itPhoto = data?.extras
                    }
                }
            }
        }




