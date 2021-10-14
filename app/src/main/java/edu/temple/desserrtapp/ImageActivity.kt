package edu.temple.desserrtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stringarray = this.resources.getStringArray(R.array.stringArray)
        val items = generateTestData(stringarray)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            imageView.setImageResource(items[itemPosition].resourceId)
            textView.text = items[itemPosition].description
        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }

    fun generateTestData(stringarray: Array<String>): Array<Item> {
        return arrayOf(Item(R.drawable.ccf_original, stringarray[0])
            , Item(R.drawable.ccf_freshstrawberry,stringarray[1])
            , Item(R.drawable.ccf_chocolatecaramelicious,stringarray[2])
            , Item(R.drawable.ccf_pineappleupsidedown,stringarray[3])
            , Item(R.drawable.ccf_celebration,stringarray[4])
            , Item(R.drawable.ccf_caramelapple,stringarray[5])
            , Item(R.drawable.ccf_verycherryghirardellichocolate,stringarray[6])
            , Item(R.drawable.ccf_lowlicious,stringarray[7])
            , Item(R.drawable.ccf_cinnaboncinnamoncwirl,stringarray[8])
            , Item(R.drawable.ccf_godiva,stringarray[9])
            , Item(R.drawable.ccf_coconutcreampie,stringarray[10])
            , Item(R.drawable.ccf_saltedcaramel,stringarray[11]))
    }
}