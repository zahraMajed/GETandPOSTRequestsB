package com.example.getandpostrequestsb

import android.app.Activity
import android.view.Display
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AIcalls {
    companion object {
        val apIinterface=APIclint().getClient()?.create(APIinterfase::class.java)

        fun postName(name:String, activity: Activity){
            apIinterface?.postName(myData.myDataItem(name,1))?.enqueue(object :
                Callback<myData.myDataItem?> {
                override fun onResponse(call: Call<myData.myDataItem?>, response: Response<myData.myDataItem?>) {
                    Toast.makeText(activity, "$name: your name has added successfully", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<myData.myDataItem?>, t: Throwable) {
                    Toast.makeText(activity, "$t error ", Toast.LENGTH_LONG).show()
                }
            })//end enqueue()
        }//end postName()

        /* fun getName(activitu: MainActivity){

            apIinterface?.getName()?.enqueue(object : Callback<myData?> {
                override fun onResponse(call: Call<myData?>, response: Response<myData?>) {
                    val response=response.body()
                    var displayName=""
                    for (item in response!!){
                        displayName += "$displayName \n ${item.name} \n"
                    }
                    activitu.tvName.text=displayName
                }
                override fun onFailure(call: Call<myData?>, t: Throwable) {
                    Toast.makeText(activitu, "$t",Toast.LENGTH_LONG).show()
                }
            })
        }//end getName()*/

    }//end comanion object
}