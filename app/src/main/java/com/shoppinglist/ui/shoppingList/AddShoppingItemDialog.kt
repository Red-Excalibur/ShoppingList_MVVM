package com.shoppinglist.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.shoppinglist.R
import com.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context,var addDialogListener : AddDialogListener):AppCompatDialog(context) {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)


   tvAdd.setOnClickListener {
       val name = etName.text.toString()
       val amount = etAmount.text.toString()

       if(name.isEmpty() || amount.isEmpty()){
           Toast.makeText(context,"please entre all the information",Toast.LENGTH_SHORT).show()
           return@setOnClickListener
       }
       val item = ShoppingItem(name, amount.toInt())
       addDialogListener.onAddButtonclicked(item)
       dismiss()
   }
        tvCancel.setOnClickListener {
            cancel() // cancel the dialog
        }
    }
}