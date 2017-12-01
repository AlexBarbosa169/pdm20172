package com.example.alexs.meuslugares

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tirar_foto.*

class TirarFotoActivity : AppCompatActivity() {
    lateinit var botaoTiraFoto: Button
    lateinit var botaoSalvar : Button
    lateinit var nomeFoto: EditText
    lateinit var descricao: EditText
    lateinit var extra: Bundle
    lateinit var foto: ImageView
    lateinit var imageBitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tirar_foto)

        botaoTiraFoto = findViewById(R.id.tirarFoto)
        botaoSalvar = findViewById(R.id.btnSalvarFoto)
        nomeFoto = findViewById(R.id.etxNomeFoto)
        descricao = findViewById(R.id.etxDescricaoFoto)
        foto = findViewById(R.id.fotoLocal)

        botaoTiraFoto.setOnClickListener({ onClickFoto(it) })

        botaoSalvar.setOnClickListener({onClickSalvar(it)})
    }

    private fun onClickSalvar(view: View?) {
        val intent = Intent()
        var msn = nomeFoto.getText()
        intent.putExtra("nome", msn.toString())
        intent.putExtra("descricao", descricao.text.toString())
        intent.putExtra("foto", this.imageBitmap)
        this.setResult(Activity.RESULT_OK,intent)
        finish()
    }

    fun onClickFoto(view: View?) {
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 1)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                extra = data!!.getExtras();
                imageBitmap = extra.get("data") as Bitmap
                foto.setImageBitmap(imageBitmap);

            } else {
                Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
            }
        }
    }
}