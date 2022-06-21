package com.safefood.ansik

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.safefood.ansik.databinding.ActivityFoodlistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FoodlistActivity : AppCompatActivity() {

     private lateinit var binding: ActivityFoodlistBinding
     private val adapter : FoodItemAdapter by lazy {
         FoodItemAdapter(this, mutableListOf())
     }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_foodlist)

        val binding = ActivityFoodlistBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.FoodRecyclerview.apply {
            this.layoutManager = LinearLayoutManager(this@FoodlistActivity)
            this.adapter = this@FoodlistActivity.adapter
            this.setHasFixedSize(true)
        }

        binding.searchBtn.setOnClickListener{
            val call: Call<FoodPageListModel> = MyApplication.networkService.getList(
                1,
                30,
                "json",
                "D2btj4YvzfYNlGj7I5O/jtStLBfeHoxtK/zNcE7Q4gUk5Vzgly91ziWRFUEd8JVq3WB+896uGVoq9RNjQ0NpfA=="

            )
            call?.enqueue(object : Callback<FoodPageListModel> {
                override fun onResponse(
                    call: Call<FoodPageListModel>,
                    response: Response<FoodPageListModel>
                ) {
                    if (response.isSuccessful) {
                        Log.d("mobileApp", "데이터${response.body()}")
                        binding.FoodRecyclerview.layoutManager = LinearLayoutManager(this@FoodlistActivity)
                        binding.FoodRecyclerview.adapter = FoodItemAdapter(this@FoodlistActivity, response.body()?.data)
                    }
                }

                override fun onFailure(call: Call<FoodPageListModel>, t: Throwable) {
                    Log.d("mobileApp", "onFailure...")
                }

            })
        }
        }

        }









