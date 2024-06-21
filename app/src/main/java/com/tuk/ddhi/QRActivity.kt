package com.tuk.ddhi

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder

class QRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

        val imageView: ImageView = findViewById(R.id.imageView)
        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.generateButton)

        button.setOnClickListener {
            val text = editText.text.toString()
            if (text.isNotEmpty()) {
                generateQRCode(text, imageView)
            }
        }
    }

    private fun generateQRCode(text: String, imageView: ImageView) {
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix: BitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap: Bitmap = barcodeEncoder.createBitmap(bitMatrix)
            imageView.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}