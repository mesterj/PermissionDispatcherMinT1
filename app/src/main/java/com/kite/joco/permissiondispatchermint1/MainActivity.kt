package com.kite.joco.permissiondispatchermint1

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import com.kite.joco.permissiondispatchermint1.databinding.ActivityMainBinding
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class MainActivity : AppCompatActivity() {
    lateinit var mybinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mybinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mybinding.root)
        mybinding.btnCall.setOnClickListener {
            callNumberWithPermissionCheck("tel:"+mybinding.etCallNum.text.toString())
        }

    }

    @NeedsPermission(Manifest.permission.CALL_PHONE)
    fun callNumber(numberString: String) {
        val intentCall = Intent(Intent.ACTION_CALL, Uri.parse(numberString))
        startActivity(intentCall)
    }
}