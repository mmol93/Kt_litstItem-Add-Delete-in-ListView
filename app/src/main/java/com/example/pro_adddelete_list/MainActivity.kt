package com.example.pro_adddelete_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.example.pro_adddelete_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. set the binding View
        val mainBinding = ActivityMainBinding.inflate(layoutInflater)

        // 2. set the date list for list item
        val textData1 = mutableListOf<String>()
        val textData2 = mutableListOf<String>()
        val indexData = mutableListOf<Int>()

        var counter1 = 1

        // 3. total list data made by No.2
        val totalListData = ArrayList<HashMap<String, Any>>()

        // 4. when clicked "ADD" btn
        mainBinding.button1.setOnClickListener {
            textData1.add(mainBinding.editText1.text.toString())
            textData2.add(mainBinding.editText2.text.toString())
            indexData.add(counter1)
            // whenever click the "ADD" btn, plus one with counter Var
            counter1 += 1

            for (i in textData1.indices){
                val map = HashMap<String, Any>()

                map["textData1"] = textData1[i]
                map["textData2"] = textData2[i]
                map["indexData"] = indexData[i]

                totalListData.add(map)
            }

            // definite the Var used in adapter Val
            val keys = arrayOf("textData1", "textData2", "indexData")
            val valuePosition = intArrayOf(R.id.list_textView2, R.id.list_textView3, R.id.list_textView_index)

            // build the ListView
            val adapter1 = SimpleAdapter(this, totalListData, R.layout.list_layout, keys, valuePosition)
            mainBinding.list1.adapter = adapter1
            textData1.clear()
            textData2.clear()
            indexData.clear()
        }

        mainBinding.button2.setOnClickListener {
            // Run the ListData when it has one data at least
            if (totalListData.size > 0){
                totalListData.removeAt(0)
                val keys = arrayOf("textData1", "textData2", "indexData")
                val valuePosition = intArrayOf(R.id.list_textView2, R.id.list_textView3, R.id.list_textView_index)

                // build the ListView
                val adapter1 = SimpleAdapter(this, totalListData, R.layout.list_layout, keys, valuePosition)
                mainBinding.list1.adapter = adapter1
            }
        }

        setContentView(mainBinding.root)
    }
}