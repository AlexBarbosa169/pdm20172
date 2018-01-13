package com.example.alexs.loterias

import android.content.Intent
import android.os.AsyncTask
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.ArrayList
import javax.net.ssl.HttpsURLConnection


/**
 * Created by alexs on 11/01/2018.
 */
 class DownloadJson : AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg params: Void): String? {
        var connection : HttpURLConnection? = null
        var reader : BufferedReader? = null

        try {
            val url = URL("https://www.lotodicas.com.br/api/lotomania")
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
        } catch (e : IOException )
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
        if(line == null){
            Log.i("Loto","Nao tem result")
        }else{
            var megaJason : JSONObject = JSONObject(line)
            var concurso : String = megaJason.getString("numero")
//            Log.i("resultLoto",result.toString())
            Log.i("Loto", concurso)
        }
    }
}