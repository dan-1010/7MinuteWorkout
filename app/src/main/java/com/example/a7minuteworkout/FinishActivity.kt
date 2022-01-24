package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.a7minuteworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    private var binding:ActivityFinishBinding?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarFinishActivity)


        if(supportActionBar!=null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnFinish?.setOnClickListener {
            finish()
        }



        val dao = (application as WorkOutApp).db.historyDao()
        addDateToDatabase(dao)

    }

    private fun addDateToDatabase(historyDao: HistoryDao){


        val c= Calendar.getInstance()
        val dateTIme= c.time
        Log.e("Date",""+dateTIme)

        val sdf=SimpleDateFormat("dd MMM yyyy HH:mm:ss",Locale.getDefault())
        val date= sdf.format(dateTIme)
        Log.e("Formatted Date: ",""+date)

        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date))
            Log.e("Date :","Added...")
        }

    }
}