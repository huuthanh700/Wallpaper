package com.example.thanhnh.wallpaperhdanime.data

import android.content.Context
import android.util.Log
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.example.thanhnh.wallpaperhdanime.util.Constants
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.util.*


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
                                var categoryAnime = CategoryAnime(node.child(Constants.KEY_CATEGORY_NAME).getValue().toString(), node.child(Constants.KEY_CATEGORY_TOTAL).getValue().toString()
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

        fun getJsonfromFirebase(context: Context, childPath: String) {
            val fileName: String = "anime.json"
            val cDir = context.getCacheDir()
            val cachingFolder = File(cDir.getPath())
            cachingFolder.mkdirs()

            val localFile: File = File(cachingFolder, fileName)

            val storage = FirebaseStorage.getInstance()
            val storageRef = storage.getReference().child(childPath)

//            val storageRef = storage.getReference().child("naruto_wallpapers.json")
//            val storageRef = storage.getReferenceFromUrl(Constants.BASE_STORAGE_LOCATION).child("naruto_wallpapers.json")

            storageRef.getFile(localFile).addOnSuccessListener({
                //process download file
                readData(localFile)
                Log.e("firebase :", "success" + localFile.path)
            }).addOnFailureListener({
                Log.e("firebase :", "fail")
            })
        }

        fun readData(localFile: File): String {
            val data: String = Scanner(File(localFile.path)).useDelimiter("\\Z").next()
            Log.e("data", data)
//            var data: MutableList<WallpaperAnime> = mutableListOf()
//            try {
//                val gson = Gson()
//                var file = FileReader(localFile)
//                data = gson.fromJson<MutableList<WallpaperAnime>>(file,
//                        object : TypeToken<MutableList<WallpaperAnime>>() {
//                        }.type
//                )
//                file.close()
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//            }
            return data
        }
    }
}

