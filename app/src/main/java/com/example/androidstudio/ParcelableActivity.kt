package com.example.androidstudio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ParcelableActivity : AppCompatActivity() {

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val returnMessage = findViewById<TextView>(R.id.textResult)
                returnMessage.text = result.data?.getStringExtra(StartActivityForResultActivity.RETURN_KEY)
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                val returnMessage = findViewById<TextView>(R.id.textResult)
                returnMessage.text = result.data?.getStringExtra(StartActivityForResultActivity.RETURN_KEY)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val textView = findViewById<TextView>(R.id.text_1)
        var receivedName: String? = null
        var receivedAge = 0
        var receivedPlace:String? = null

        // Intentの受け取り
        if (intent != null) {
            // Intentからデータを取り出す
            val parcel = intent.getParcelableExtra<ParcelableData>(MainActivity.PARCEL_KEY)
            receivedName = parcel?.name
            receivedAge = parcel?.id ?: 0
            receivedPlace = parcel?.place
        }

        // Viewの参照の取得
        val receivedResultName  = findViewById<TextView>(R.id.receivedName)
        val receivedResultAge  = findViewById<TextView>(R.id.receivedAge)
        val receivedResultPlace  = findViewById<TextView>(R.id.receivedPlace)

        // データのセット
        receivedResultName .text = receivedName
        receivedResultAge .text = receivedAge.toString()
        receivedResultPlace.text = receivedPlace

        findViewById<Button>(R.id.button_result).setOnClickListener {
            //設定
            val intent =
                Intent(this@ParcelableActivity, StartActivityForResultActivity::class.java).also {
                    it.putExtra(NAME_KEY, "山田花子")
                    it.putExtra(AGE_KEY, 15)
                    it.putExtra(PLACE_KEY, "北海道在住")
                }
            startForResult.launch(intent)
        }
    }
    companion object{
        const val NAME_KEY = "name"
        const val AGE_KEY = "age"
        const val PLACE_KEY = "place"
    }
}