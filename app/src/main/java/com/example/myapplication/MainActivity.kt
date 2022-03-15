package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import pub.devrel.easypermissions.EasyPermissions


class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    private lateinit var binding: ActivityMainBinding
    private  lateinit  var getResult: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bt.setOnClickListener {

          //  startActivityForResult(Intent(Intent.ACTION_GET_CONTENT).also { it.setType("image/*") },1)
            getResult?.launch(Intent(Intent.ACTION_GET_CONTENT).also { it.setType("image/*") })
        }


          getResult =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val value = it.data
                    Picasso.get().load(value?.data).into(binding.imageView)

                }
            }

    }


   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val dat= data?.data
        Picasso.get().load(dat).into(binding.imageView)
        Log.d("ntent","${data?.data}")
    }*/


    fun hasWriteInExternalStoragePersmission() =
        EasyPermissions.hasPermissions(
            this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)


    fun requestExternalStoragePermission() =
        EasyPermissions.requestPermissions(
            this,
            "you should accespt",
            1,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        Toast.makeText(this, "permission granted", Toast.LENGTH_LONG).show()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Toast.makeText(this, "permission not granted", Toast.LENGTH_LONG).show()
    }


}