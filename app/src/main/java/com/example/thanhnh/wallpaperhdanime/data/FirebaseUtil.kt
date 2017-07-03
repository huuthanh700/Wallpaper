package com.example.thanhnh.wallpaperhdanime.data

import android.util.Log
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.example.thanhnh.wallpaperhdanime.data.model.WallpaperAnime
import com.example.thanhnh.wallpaperhdanime.util.Constants
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.*
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader


/**
 * Created by ThanhNH on 6/29/2017.
 */
open class FirebaseUtil {
    companion object {
        //Firebase
        var database: FirebaseDatabase? = null
        var databaseRef: DatabaseReference? = null
        var listCategory: ArrayList<CategoryAnime>? = ArrayList()

        fun getListCategory(): List<CategoryAnime>? {
            /*firebase*/
            database = FirebaseDatabase.getInstance()
            databaseRef = database?.getReference()
            databaseRef?.child("animes")?.addListenerForSingleValueEvent(
                    object : ValueEventListener {
                        override fun onDataChange(p0: DataSnapshot?) {
                            var nodes: Iterator<DataSnapshot> = p0?.children?.iterator()!!
                            while (nodes.hasNext()) {
                                var node: DataSnapshot = nodes.next()
                                var categoryAnime: CategoryAnime = CategoryAnime(node.child(Constants.KEY_CATEGORY_NAME).getValue().toString(), node.child(Constants.KEY_CATEGORY_TOTAL).getValue().toString()
                                        , node.child(Constants.KEY_CATEGORY_COVER).getValue().toString(), node.child(Constants.KEY_CATEGORY_CONTENT).getValue().toString())
                                listCategory?.add(categoryAnime)
                            }
//                            getJsonfromFirebase()
                        }

                        override fun onCancelled(p0: DatabaseError?) {

                        }
                    })
            return listCategory
        }

        fun getJsonfromFirebase() {
            val storage = FirebaseStorage.getInstance()
            val storageRef = storage.getReferenceFromUrl(Constants.BASE_STORAGE_LOCATION).child("naruto_wallpapers.json")
            val localFile: File = File.createTempFile("anime", "json")
            storageRef.getFile(localFile).addOnSuccessListener {
                OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    //process download file
//                    readData(localFile)
                    Log.e("firebase :", "success")
                }
            }.addOnFailureListener({
                Log.e("firebase :", "fail")
            })
        }

        fun readData(localFile: File): MutableList<WallpaperAnime> {
            var data: MutableList<WallpaperAnime> = mutableListOf()
            try {
                val gson = Gson()
                var file = FileReader(localFile)
                data = gson.fromJson<MutableList<WallpaperAnime>>(file,
                        object : TypeToken<MutableList<WallpaperAnime>>() {
                        }.type
                )
                file.close()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
            return data
        }
    }
}

