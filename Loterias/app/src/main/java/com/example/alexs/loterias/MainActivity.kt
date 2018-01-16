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
    lateinit var url : String

    val MEGA = "https://www.lotodicas.com.br/api/mega-sena"
    val QUINA = "https://www.lotodicas.com.br/api/quina"
    val LOTOFACIL = "https://www.lotodicas.com.br/api/loto-facil"
    val LOTOMANIA = "https://www.lotodicas.com.br/api/lotomania"


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
        if(view.getTag().equals("mega")){
            url = MEGA
        }else if(view.getTag().equals("lotomania")){
            url = LOTOMANIA
        }else if(view.getTag().equals("lotofacil")){
            url = LOTOFACIL
        }else{
            url = QUINA
        }
//        val aposta = ApostaLotomania(1111,1,2,3,4,5,6)
//
//        Log.i("aposta", aposta.toString())
//
//        this.daoApostaLotomania.insert(aposta)
//        this.daoApostaLotomania.delete(1111)

        var download = DownJson()
        download.execute(url)

//        Log.i("jogosalvo", this.daoApostaLotomania.select().size.toString())
    }

    inner class DownJson : AsyncTask<String, Void, String>()  {
        override fun doInBackground(vararg p0: String): String? {
            var connection : HttpURLConnection? = null
            var reader : BufferedReader? = null
            try {
                val url2 = URL(p0.get(0))
                connection = url2.openConnection() as HttpURLConnection
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
        }

        override fun onPostExecute(line : String?) {
//            var it = Intent(this@MainActivity,MegaSenaActivity::class.java)
            var numeros : ArrayList<Int> = arrayListOf<Int>()
            if(line == null){
                Log.i("Loto","Nao tem result")
            }else{
                var megaJason : JSONObject = JSONObject(line)
                var concurso : String = megaJason.getString("numero")
                var sorteio : JSONArray? = megaJason.getJSONArray("sorteio")
                if(url.contains("mega",ignoreCase = true)){
                    var it = Intent(this@MainActivity,MegaSenaActivity::class.java)
                    it.putExtra("consurso",concurso)
                    it.putExtra("json", megaJason.toString())
                    Log.i("opcao","Mega")
                    startActivity(it)
                }
                else if (url.contains("lotomania")){
                    var it = Intent(this@MainActivity,LotomaniaActivity::class.java)
                    it.putExtra("json", megaJason.toString())
                    Log.i("opcao","Lotomania")
                    startActivity(it)
                }else if (url.contains("lotofacil")){
                    var it = Intent(this@MainActivity,MegaSenaActivity::class.java)
                    it.putExtra("consurso",concurso)
                    it.putExtra("json", megaJason.toString())
                    Log.i("opcao","lotofacil")
                    startActivity(it)
                }else{
                    var it = Intent(this@MainActivity,Quina2Activity::class.java)
                    it.putExtra("json", megaJason.toString())
                    Log.i("opcao","quina")
                    startActivity(it)
                }
//                var numeros = arrayListOf<Int>()
//
//                for (i in 0..5) {
//                    numeros.add(i)
//                        numeros.add(sorteio!!.get(i) as Int)
//                }


            }
        }
    }
}
