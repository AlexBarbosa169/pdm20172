package com.example.alexs.loterias

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_mega_sena.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class MainActivity : AppCompatActivity() {

    lateinit var imgLotoMania: ImageView
    lateinit var imgLotoFacil: ImageView
    lateinit var imgMegaSena: ImageView
    lateinit var imgQuina: ImageView
    lateinit var txtText: TextView
    lateinit var daoApostaLotomania : ApostaLotomaniaDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgLotoFacil = findViewById(R.id.imgLotofacil)
        imgLotoMania = findViewById(R.id.imgLotomania)
        imgMegaSena = findViewById(R.id.imgMegasena)
        imgQuina = findViewById(R.id.imgQuina)
        txtText = findViewById(R.id.textTeste)

        this.imgLotoFacil.setOnClickListener({ onClickView(it as ImageView) })
        this.imgLotoMania.setOnClickListener({ onClickView(it as ImageView) })
        this.imgMegaSena.setOnClickListener({ onClickView(it as ImageView) })
        this.imgQuina.setOnClickListener({ onClickView(it as ImageView) })
        this.daoApostaLotomania = ApostaLotomaniaDAO(this)
    }

    fun onClickView(view: ImageView) {
        txtText.text = "Clicou!"

//        val aposta = ApostaLotomania(1111,1,2,3,4,5,6)
//
//        Log.i("aposta", aposta.toString())
//
//        this.daoApostaLotomania.insert(aposta)
//        this.daoApostaLotomania.delete(1111)

        var download = DownJson()
        download.execute()

//        var itMegasena = Intent(this,MegaSenaActivity::class.java)
//        startActivity(itMegasena)


//        Log.i("jogosalvo", this.daoApostaLotomania.select().size.toString())
    }

    inner class DownJson : AsyncTask<Void, Void, String>()  {
        override fun doInBackground(vararg params: Void): String? {
            var connection : HttpURLConnection? = null
            var reader : BufferedReader? = null

            try {
                val url = URL("https://www.lotodicas.com.br/api/mega-sena")
                connection = url.openConnection() as HttpURLConnection
                connection.connect()
                val stream = connection.inputStream
                reader = BufferedReader(InputStreamReader(stream))
                val buffer = StringBuffer()
                var line = reader.readLine()

                buffer.append(line)

                return buffer.toString()

            }
            catch (e : MalformedURLException)
            {
                e.printStackTrace();
            } catch (e : IOException)
            {
                e.printStackTrace();
            } catch (e : JSONException)
            {
                e.printStackTrace();
            } finally
            {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (e : IOException) {
                    e.printStackTrace();
                }
            }
            return null
//        try {
//            var url = URL("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesData.txt")
//            connection = url.openConnection() as HttpsURLConnection
//            connection.connect()
//            var stream : InputStream = connection.inputStream
//            reader = BufferedReader(InputStreamReader(stream))
//            var line : String = reader.readLine()
//            Log.i("minhaurl",line)
//            return line
//
//        }catch (e : Exception){
//            e.printStackTrace()
//        }
//
//        return null
        }

        override fun onPostExecute(line : String?) {
            var it = Intent(this@MainActivity,MegaSenaActivity::class.java)
            var numeros : ArrayList<Int> = arrayListOf<Int>()
            if(line == null){
                Log.i("Loto","Nao tem result")
            }else{
                var megaJason : JSONObject = JSONObject(line)
                var concurso : String = megaJason.getString("numero")
                var sorteio : JSONArray? = megaJason.getJSONArray("sorteio")


                for (i in 0..5) {
                    numeros.add(i)
                        numeros.add(sorteio!!.get(i) as Int)
                }

                it.putExtra("consurso",concurso)
//                it.putExtra("numeros", numeros.toArray())
                it.putExtra("json", megaJason.toString())

                startActivity(it)
//            Log.i("resultLoto",result.toString())
                Log.i("Loto", concurso)
                Log.i("sorteados", sorteio.toString())
                Log.i("numeros", numeros.toString())
            }
        }
    }
}
