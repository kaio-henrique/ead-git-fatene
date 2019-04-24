package com.kaiohenrique.eadgitfatene

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaiohenrique.eadgitfatene.dialog.MessageDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        actionShowDialog.setOnClickListener { buildDialog() }
    }

    private fun buildDialog() {
        val dialog = MessageDialogFragment.newInstance(
            getString(R.string.txt_title_dialog),
            getString(R.string.txt_message_dialog)
        )

        showDialog(dialog)
    }

    private fun showDialog(dialog: MessageDialogFragment) {
        if (dialog.isVisible) return
        dialog.show(supportFragmentManager, dialog.tag)
    }
}
