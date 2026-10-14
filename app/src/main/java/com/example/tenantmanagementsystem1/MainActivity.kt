package com.example.tenantmanagementsystem1

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.tenantmanagementsystem1.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val rent = binding.rentEditText.text.toString()

            binding.tenantResultTextView.text =
                "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
        }
    }
}