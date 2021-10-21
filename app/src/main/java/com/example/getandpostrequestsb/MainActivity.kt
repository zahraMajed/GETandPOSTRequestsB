package com.example.getandpostrequestsb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var edName: EditText
    lateinit var btnSave: Button
    lateinit var tvName: TextView
    lateinit var btnView:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName=findViewById(R.id.edName)
        btnSave=findViewById(R.id.btnSave)
        tvName=findViewById(R.id.tvName)
        btnView=findViewById(R.id.btnView)

        btnSave.setOnClickListener(){
            if (edName.text.isNotEmpty()){
                AIcalls.postName(edName.text.toString(), this)
            }else
                Toast.makeText(applicationContext, "empty entry", Toast.LENGTH_LONG).show()
        }//end listener

        btnView.setOnClickListener(){
            getName()
        }//end listener

    }//end on create
    fun getName(){
        val apIinterface=APIclint().getClient()?.create(APIinterfase::class.java)
        apIinterface?.getName()?.enqueue(object : Callback<List<myData.myDataItem>?> {
            override fun onResponse(call: Call<List<myData.myDataItem>?>, response: Response<List<myData.myDataItem>?>) {
                val response=response.body()
                var displayName=""
                for (item in response!!){
                    displayName = " $displayName \n ${item.name} \n"
                }
                tvName.text=displayName
            }

            override fun onFailure(call: Call<List<myData.myDataItem>?>, t: Throwable) {
                Toast.makeText(applicationContext, "$t",Toast.LENGTH_LONG).show()
            }
        })
    }//end getName()

}//end class


