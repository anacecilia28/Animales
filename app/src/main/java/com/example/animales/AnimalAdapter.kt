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

class AnimalAdapter (private val tipoId: String, context: Context) :

    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var listaAnimales = AnimalOrganized().obtenerAnimalPorTipo(tipoId)

    class AnimalViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = AnimalAdapter

        return AnimalViewHolder(layout)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val item = listaAnimales[position]

        val context = holder.view.context

        holder.button.text = item.nombreAnimal

        //Implementamos el evento cuando el usuario da un click en el botón de tipos
        holder.button.setOnClickListener{
            val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listaAnimales.size


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
            val customString = host?.context?.getString(R.string.look_up_animal)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }

    }


}