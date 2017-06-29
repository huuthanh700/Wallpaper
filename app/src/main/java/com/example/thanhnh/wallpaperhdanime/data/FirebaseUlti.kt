package com.example.thanhnh.wallpaperhdanime.data

import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.example.thanhnh.wallpaperhdanime.util.Constants
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import android.support.annotation.NonNull




/**
 * Created by ThanhNH on 6/29/2017.
 */
open class FirebaseUlti {
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

                            /*Firebase storage*/
                            val storage = FirebaseStorage.getInstance()
                            var gsStoreRef: StorageReference = storage?.getReferenceFromUrl(listCategory?.get(1)?.mContent as String)
                            val ONE_MEGABYTE = (1024 * 1024).toLong()
                            gsStoreRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(OnSuccessListener<ByteArray> {
                                // Data for "images/island.jpg" is returns, use this as needed
                            }).addOnFailureListener(OnFailureListener {
                                // Handle any errors
                            })

                        }

                        override fun onCancelled(p0: DatabaseError?) {

                        }
                    })
            return listCategory
        }
    }
}
