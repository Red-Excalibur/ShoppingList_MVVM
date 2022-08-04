package com.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoppinglist.R
import com.shoppinglist.data.db.entities.ShoppingItem
import com.shoppinglist.ui.shoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter (
    var items :List<ShoppingItem>
    ,val viewModel : ShoppingViewModel
        ):RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
   val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        //we save our current item position
       val currentShoppingItem = items[position]

        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text="${currentShoppingItem.amount}" // cuz it's integer
//this is perfect just master it ..u can do that for every item clickers and stuff

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
    holder.itemView.ivPlus.setOnClickListener {
    currentShoppingItem.amount++
        //update it wont ad new one
        viewModel.insert(currentShoppingItem)
}

        holder.itemView.ivMinis.setOnClickListener {
            if(currentShoppingItem.amount>0){ currentShoppingItem.amount--
                //Room will update it wont insert  new one with new entry
                viewModel.insert(currentShoppingItem)
            }

        }

    }

    override fun getItemCount(): Int {
return items.size
    }

    inner class ShoppingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)


}