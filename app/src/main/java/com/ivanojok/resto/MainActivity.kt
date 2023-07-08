package com.ivanojok.resto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.ivanojok.resto.data.FoodAdapter
import com.ivanojok.resto.data.FoodModel
import com.ivanojok.resto.data.Preferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list = ArrayList<FoodModel>()
//        list.add(FoodModel("Chicken", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//        list.add(FoodModel("Matooke", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//        list.add(FoodModel("Rice", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//        list.add(FoodModel("Sausages", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//        list.add(FoodModel("Wings", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//        list.add(FoodModel("Chappati", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//        list.add(FoodModel("Cake", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//        list.add(FoodModel("Samosa", "UGX. 20,000", "Plantain, Plantain,Plantain Plantain,Plantain PlantainPlantain, PlantainPlantainPlantainPlantain"))
//
//        val myAdapter = FoodAdapter(this, list)
//        val recycler = findViewById<RecyclerView>(R.id.food_recycler)
//        recycler.adapter = myAdapter
        val list = ArrayList<FoodModel>()
        createRecycler(list)

        val recyclerLayout = findViewById<ConstraintLayout>(R.id.recycler_layout)
        val addFoodLayout = findViewById<ConstraintLayout>(R.id.add_food_layout)
        val addFood = findViewById<ImageView>(R.id.addFood)
        addFood.setOnClickListener {
            recyclerLayout.visibility = View.GONE
            addFoodLayout.visibility = View.VISIBLE
        }

        /** Adding food items */
        val addFoodName = findViewById<TextInputEditText>(R.id.add_food_name)
        val addFoodPrice = findViewById<TextInputEditText>(R.id.add_food_price)
        val addFoodDescription = findViewById<TextInputEditText>(R.id.add_food_description)
        val addFoodButton = findViewById<Button>(R.id.add_food_button)


        addFoodButton.setOnClickListener {
            val foodName = addFoodName.text.toString()
            val foodPrice = addFoodPrice.text.toString()
            val foodDescription = addFoodDescription.text.toString()

            if (foodName.isNotEmpty() && foodPrice.isNotEmpty() && foodDescription.isNotEmpty()) {
                list.add(FoodModel(foodName, foodPrice, foodDescription))
                recyclerLayout.visibility = View.VISIBLE
                addFoodLayout.visibility = View.GONE
                createRecycler(list)
            }
            else {
                Toast.makeText(this, "Information is Empty", Toast.LENGTH_LONG).show()
            }
        }


    }

    fun createRecycler(list: ArrayList<FoodModel>) {
        val myAdapter = FoodAdapter(this, list)
        val recycler = findViewById<RecyclerView>(R.id.food_recycler)
        recycler.adapter = myAdapter
        recycler.layoutManager = LinearLayoutManager(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this).inflate(R.menu.logout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val logout = item.itemId
        if (logout == R.id.logout) {
            val preferences = Preferences(this).sharedPreferences
            preferences.all.clear()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}