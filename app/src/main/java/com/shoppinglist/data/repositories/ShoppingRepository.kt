package com.shoppinglist.data.repositories

import com.shoppinglist.data.db.ShoppingItemsDataBase
import com.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db : ShoppingItemsDataBase
) {
    suspend fun insert (item : ShoppingItem)=db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem)=db.getShoppingDao().delete(item)

     fun getAllShoppingItems()=db.getShoppingDao().getAllShoppingItems()
}