package com.icanerdogan.oneandtwowaybinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.icanerdogan.oneandtwowaybinding.databinding.ActivityMainBinding
import com.icanerdogan.oneandtwowaybinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewmodel = mainViewModel
        }

        // observe :her değişiklik olduğunda tetiklenir!
        mainViewModel.editTextContent.observe(this, Observer { letter ->
            Toast.makeText(this, letter, Toast.LENGTH_SHORT).show()
        })
    }
}