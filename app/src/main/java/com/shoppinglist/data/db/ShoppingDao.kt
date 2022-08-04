package com.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    //for a reeading operation we don't need to launch it in a coroutine
    @Query("SELECT * FROM shopping_items")
     fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}