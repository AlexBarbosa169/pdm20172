package com.example.alexs.meuslugares

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlin.collections.ArrayList


class Lugares2Activity : AppCompatActivity() {
    lateinit var lista : ListView
    lateinit var btnAdd : Button
    lateinit var extra : Bundle
    lateinit var lugares : ArrayList<Lugar>
    lateinit var imagens : ArrayList<Bitmap>
    lateinit var imgVies : ImageView
    var latitude : Double = 0.0
    var longitude : Double = 0.0
    var nomes = arrayListOf<String>("")
//    Adicionando local
    lateinit var gpsManager : LocationManager
    lateinit var gpsListener : LocationListener

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares2)
        lugares = arrayListOf()
        imagens = arrayListOf()
        lista = findViewById(R.id.lista)
        btnAdd = findViewById(R.id.btnAddLugares)
        imgVies = findViewById(R.id.imgView)
        btnAdd.setOnClickListener({tirarFoto(it)})
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes)
        this.lista.adapter = adapter
        this.lista.setOnItemClickListener({parent, view, position, id -> abrirImagem(position)})

        this.gpsManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        this.gpsListener = GPSListener()

    }

    @SuppressLint("MissingPermission")
    override fun onResume() {
        super.onResume()

        this.gpsManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this.gpsListener)
    }

    private fun abrirImagem(position: Int) {
        val itTelaImagem = Intent(this,LocalActivity::class.java)
        itTelaImagem.putExtra("nome",lugares.get(position -1).nome)
        itTelaImagem.putExtra("descricao",lugares.get(position -1).descricao)
        itTelaImagem.putExtra("imagem", imagens.get(position - 1))
        itTelaImagem.putExtra("latitude",this.latitude.toString())
        itTelaImagem.putExtra("longitude",this.longitude.toString())
        startActivity(itTelaImagem)
    }

    fun tirarFoto(view: View){
        val itTirarFoto = Intent(this, TirarFotoActivity::class.java)
//        val itTirarFoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(itTirarFoto,1)
    }

    @SuppressLint("MissingPermission")
    fun adicionarLocal(){
        this.gpsManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this.gpsListener)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                extra = data!!.getExtras()
//                Testando uma classe para armazenar um lugar
                var lugar = Lugar(extra.get("nome") as String ,extra.get("descricao") as String, this.latitude,this.longitude)
                lugares.add(lugar)
//
                var imageBitmap : Bitmap = extra.get("foto") as Bitmap
                imagens.add(imageBitmap)
//                imgVies.setImageBitmap(imagens.get(imagens.size - 1));
                val msn = extra.get("nome")


                    (this.lista.adapter as ArrayAdapter<String>).add(msn.toString())

                Toast.makeText(this,"Salvo",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"Erro",Toast.LENGTH_SHORT).show()
            }
        }
    }
//  Classe interna adicionar Local

    inner class GPSListener: LocationListener{

        override fun onLocationChanged(location: Location?) {
            latitude = location?.latitude!!
            longitude = location?.longitude!!
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderEnabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderDisabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}
