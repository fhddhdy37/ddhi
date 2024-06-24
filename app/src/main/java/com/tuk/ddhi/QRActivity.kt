package com.tuk.ddhi

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.util.UUID

class QRActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qractivity)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Generate random key
        val randomKey = generateRandomKey()

        // Generate QR code
        generateQRCode(randomKey, imageView)

        findViewById<Button>(R.id.scanSuccessButton).setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    private fun generateRandomKey(): String {
        // Use UUID to generate a random key
        return UUID.randomUUID().toString()
    }

    private fun generateQRCode(text: String, imageView: ImageView) {
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            imageView.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}