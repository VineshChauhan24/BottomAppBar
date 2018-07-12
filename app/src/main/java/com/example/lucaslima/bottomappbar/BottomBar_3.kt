package com.example.lucaslima.bottomappbar

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_bottom_bar_2.*

class BottomBar_3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar_1)
        setSupportActionBar(bottom_app_bar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4568DC")));

        fab.setOnClickListener {
            toast("Fab clicked!")
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_2, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this, Principal::class.java)

        when (item!!.itemId) {
            R.id.option_1 -> toast("Option 1 clicked!")
            R.id.option_2 -> toast("Option 2 clicked!")
            R.id.option_3 -> toast("Option 3 clicked!")
            R.id.option_4 -> toast("Option 4 clicked!")

        }

        if (item.itemId == android.R.id.home){
            startActivity(intent)
            finish()
        }
        return true
    }

    override fun onBackPressed() {
        val intent = Intent(this, Principal::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    // Create an extension method for easy Toast call
    fun Context.toast(message: CharSequence) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM, 0, 325)
        toast.show()
    }
}
