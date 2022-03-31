package com.example.animales

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class TipoAdapter(context: Context):
    RecyclerView.Adapter<TipoAdapter.TipoViewHolder>() {

    private val tipoAnimal: List<String> = context.resources.getStringArray(R.array.tipos).toList()

    class TipoViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipoViewHolder {
        TODO("Not yet implemented")
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = Accessibility

            return TipoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TipoAdapter.TipoViewHolder, position: Int) {
        TODO("Not yet implemented")
        val item = tipoAnimal[position]
        // Needed to call startActivity
        val context = holder.view.context

        // Set the text of the TipoViewHolder
        holder.button.text = item

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    // Setup custom accessibility delegate to set the text read with
    // an accessibility service
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.look_up_word)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }
    }



}