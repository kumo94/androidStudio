package com.example.androidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //インスタンス取得
        val textView = findViewById<TextView>(R.id.text)
        val button = findViewById<Button>(R.id.button_1)
        Log.d("LifeCycle", "onCreate")

        //クリック処理の追加
        button.setOnClickListener{
            //TextViewがすでに選択＝クリックされているか
            if (it.isSelected){
                //TextViewがすでに選択＝クリックされているか
                textView.text = "Hello World"
            }else{
                textView.text = "Button is Clicked!"
            }
            //選択状態を反転させる
            it.isSelected = !it.isSelected
            Log.d("LifeCycle", "setOnClickListener")
        }

        //画面遷移処理
        val button2 = findViewById<Button>(R.id.button_2)
        button2.setOnClickListener{
            //ここに処理を追加
            val intent = Intent(this@MainActivity, SubActivity::class.java)
            intent.putExtra("test", "Hello World!")
            startActivity(intent)
            Log.d("LifeCycle", "setOnClickListener")
        }

        val button3 = findViewById<Button>(R.id.button_3)
        button3.setOnClickListener{
            val parcelableData = ParcelableData(22,"山田太郎","東京都在住")
            val intent = Intent(this,ParcelableActivity::class.java).also {
                it.putExtra(PARCEL_KEY, parcelableData)
            }
            startActivity(intent)
        }
    }
    companion object {
        const val PARCEL_KEY = "ユーザー情報"
    }
}