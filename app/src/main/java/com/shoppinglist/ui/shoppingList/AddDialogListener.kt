package com.shoppinglist.ui.shoppingList

import com.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    //we need to pass the data from the dialog class to the main activity
    fun onAddButtonclicked(item:ShoppingItem)
}