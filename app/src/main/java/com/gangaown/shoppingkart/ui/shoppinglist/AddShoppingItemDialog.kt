package com.gangaown.shoppingkart.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.gangaown.shoppingkart.R
import com.gangaown.shoppingkart.data.db.entities.ShoppingItem
import com.gangaown.shoppingkart.databinding.DialogAddShoppingItemBinding


class AddShoppingItemDialog(context:Context,var addDialogListener:AddDialogListener):AppCompatDialog(context) {

    private lateinit var binding:DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.tvAdd.setOnClickListener{
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if(name.isEmpty()||amount.isEmpty()){
                Toast.makeText(context,"Please enter all the details! ",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener{
            cancel()
        }
    }
}