package com.example.tenantmanagementsystem1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    companion object {
        private const val TAG = "TENANT_LIFECYCLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "LoginActivity: onCreate")

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // If RegisterActivity sent an email back, pre-fill it
        val emailFromIntent = intent.getStringExtra("EMAIL")
        if (emailFromIntent != null) {
            binding.emailEditText.setText(emailFromIntent)
        }

        // ── LOGIN button ──
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter your email and password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val mainIntent = Intent(this, MainActivity::class.java)
                mainIntent.putExtra("EMAIL", email)   // Step 15: send the email to MainActivity
                startActivity(mainIntent)
                finish()   // close Login so Back doesn't return here
            }
        }

        // ── REGISTER link ──
        binding.registerTextView.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }

        // ── HELP link ──
        binding.helpTextView.setOnClickListener {
            val helpIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.strathmore.edu")
            )
            startActivity(helpIntent)
        }
    }

    // ── LIFECYCLE LOGS ──
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "LoginActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "LoginActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "LoginActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "LoginActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "LoginActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "LoginActivity: onDestroy")
    }
}