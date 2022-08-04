package com.shoppinglist.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.shoppinglist.data.db.entities.ShoppingItem
import com.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) :ViewModel() {

    fun insert(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    //here we don't need a coroutine cuz its just a read operation
    fun getAllShoppingItems()=repository.getAllShoppingItems()
}