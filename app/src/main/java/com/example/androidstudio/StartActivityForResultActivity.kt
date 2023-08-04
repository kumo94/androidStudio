package com.example.androidstudio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StartActivityForResultActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click)
        val textView = findViewById<TextView>(R.id.text_1)
        var receivedName: String? = null
        var receivedAge = 0
        var receivedPlace:String? = null

        // Intentの受け取り
        if (intent != null) {
            // ParcelableからのIntentのデータの取り出し
            receivedName = intent.getStringExtra(ParcelableActivity.NAME_KEY)
            receivedAge = intent.getIntExtra(ParcelableActivity.AGE_KEY, 0)
            receivedPlace = intent.getStringExtra(ParcelableActivity.PLACE_KEY)
        }

        // View参照の取得
        val receivedResultName = findViewById<TextView>(R.id.receivedName)
        val receivedResultAge = findViewById<TextView>(R.id.receivedAge)
        val receivedResultAddress = findViewById<TextView>(R.id.receivedPlace)

        // Data Set
        receivedResultName.text = receivedName
        receivedResultAge.text = receivedAge.toString()
        receivedResultAddress.text = receivedPlace

        val okBtn = findViewById<Button>(R.id.button_ok)
        okBtn.setOnClickListener(View.OnClickListener {
            val okIntent = Intent()
            okIntent.putExtra(
                RETURN_KEY,
                "OK: 確認しました。"
            )
            // resultCodeをセット
            setResult(RESULT_OK, okIntent)
            finish()
        })

        val cancelBtn = findViewById<Button>(R.id.button_cancel)
        cancelBtn.setOnClickListener(View.OnClickListener {
            val cancelIntent = Intent()
            cancelIntent.putExtra(
                RETURN_KEY,
                "キャンセル:入力し直してください。"
            )
            setResult(RESULT_CANCELED, cancelIntent)
            finish()
        })

    }
    companion object {
        const val RETURN_KEY = "ReturnKey"
    }
}