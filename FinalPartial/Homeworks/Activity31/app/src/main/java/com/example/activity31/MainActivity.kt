package com.example.activity31

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodList : MutableList<Food> = ArrayList()
        val jsonString = """
            [
            {'name':'burger', 'price':15, 'description':'a juicy burger!'},
            {'name':'hotdog', 'price':20, 'description':'an ok hot dog'},
            {'name':'tacos', 'price':12, 'description':'some pretty good tacos'},
            {'name':'torta', 'price':22, 'description':'nice torta'},
            {'name':'carne asada', 'price':50, 'description':'a great carne asada'}
            ]
        """.trimIndent()
        //Toast.makeText(this,jsonString,Toast.LENGTH_SHORT).show()
        val foods = JSONArray(jsonString)
        for (i in 0 until foods.length()){
            val jsonObject = foods.getJSONObject(i)
            val food = Food(jsonObject.optString("name"),jsonObject.optInt("price"),jsonObject.optString("description"))
            foodList.add(food)
        }
        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.adapter = FoodAdapter(foodList)
    }
}

