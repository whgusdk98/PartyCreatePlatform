package com.sopt.partyflatform

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.loader.content.CursorLoader
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_regist.view.*


class RegistFragment : Fragment() {

    val MY_READ_STORAGE_REQUEST_CODE = 1
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    private lateinit var regist_img : ImageView
    private var mImageURL: String? = null
    private lateinit var rankingFragment : RankingFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val regist_view = inflater.inflate(R.layout.fragment_regist, container, false)


        regist_img = regist_view.findViewById(R.id.regist_img)

        regist_img.setOnClickListener {
            requestReadExternalStoragePermission()
        }
        rankingFragment = RankingFragment()

        regist_view.btn_regist.setOnClickListener {
            Toast.makeText(context, "등록되었습니다.", Toast.LENGTH_SHORT).show()
            fragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.container, rankingFragment)?.commit()
        }


        return regist_view

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    val selectedImageUri: Uri = data.data!!
                    mImageURL = getRealPathFromURI(selectedImageUri)
                    Log.d("eeeee1", mImageURL)

                    Glide.with(this).load(selectedImageUri)
                        .into(regist_img)
                }
            }
        }
    }

    private fun requestReadExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(
                context!!,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity!!,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {

            } else {
                ActivityCompat.requestPermissions(
                    activity!!,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    MY_READ_STORAGE_REQUEST_CODE
                )
            }
        } else {
            showAlbum()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == MY_READ_STORAGE_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAlbum()
            } else {
                activity!!.finish()
            }
        }
    }

    private fun showAlbum() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
    }

    fun getRealPathFromURI(content: Uri): String {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val loader: CursorLoader = CursorLoader(context!!, content, proj, null, null, null)
        val cursor: Cursor? = loader.loadInBackground()
        val column_idx = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor!!.moveToFirst()
        val result = cursor.getString(column_idx)
        cursor.close()
        return result
    }


}
