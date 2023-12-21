package com.example.copydemo

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView:TextView = findViewById(R.id.copyTextView)
        val copyButton:ImageView = findViewById(R.id.copyButton)

        copyButton.setOnClickListener {
            val textToCopy = textView.text.toString()

            val clipBoardManager = getSystemService(Context.CLIPBOARD_SERVICE)
                    as ClipboardManager
            clipBoardManager.setPrimaryClip(
                android.content.ClipData.newPlainText("text",textToCopy)
            )

            Toast.makeText(this,"Text Copied",Toast.LENGTH_SHORT).show()
        }

    }
}