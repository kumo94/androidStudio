package com.example.androidstudio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class IntentFilterTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        findViewById<Button>(R.id.button_hello).setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_mail).setOnClickListener{
            val intent = Intent().also {
                it.action = Intent.ACTION_SENDTO
                it.data = Uri.parse("mailto:")
                it.putExtra(Intent.EXTRA_SUBJECT, "インテントフィルターのテスト")
                it.putExtra(Intent.EXTRA_TEXT, "起動に成功したよ")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_internet).setOnClickListener{
            val intent = Intent().also {
                it.action = Intent.ACTION_VIEW
                it.data = Uri.parse("https://www.google.co.jp/")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_map).setOnClickListener{
            val intent = Intent().also {
                it.action = Intent.ACTION_VIEW
                it.data = Uri.parse("https://www.google.co.jp/maps/")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_book).setOnClickListener{
            val intent = Intent().also {
                it.action = Intent.ACTION_VIEW
                it.data = Uri.parse("Contacts:")
            }
            startActivity(intent)
        }
    }
}