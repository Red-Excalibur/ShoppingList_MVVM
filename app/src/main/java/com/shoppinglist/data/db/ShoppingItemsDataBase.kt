package com.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shoppinglist.data.db.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingItemsDataBase :RoomDatabase(){

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance : ShoppingItemsDataBase? = null
        private val Lock =Any()

           operator fun invoke(context: Context)= synchronized(Lock){
               instance ?: createDataBase(context).also {
                   instance =it
               }
           }


        private fun createDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingItemsDataBase::class.java
                ,"shoppingdataBase.db").build()

    }
}