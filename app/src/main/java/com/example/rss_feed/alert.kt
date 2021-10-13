package com.example.rss_feed

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.Spanned
import android.widget.TextView

fun alert(mes: Spanned, toptitle:String, cont: Context) {
    val dialogBuilder = AlertDialog.Builder(cont)

    // set message of alert dialog
    dialogBuilder.setMessage(mes)

        // if the dialog is cancelable
        .setCancelable(false)
    // positive button text and action
    dialogBuilder.setPositiveButton("Got It", DialogInterface.OnClickListener { dialog, id ->
        dialog.cancel()
    })
    // negative button text and action
//        .setNegativeButton("No", DialogInterface.OnClickListener {
//                dialog, id -> dialog.cancel()
//        })

    // create dialog box
    val alert = dialogBuilder.create()
    // set title for alert dialog box

    alert.setTitle(toptitle)

    // show alert dialog
    alert.show()
    val a: TextView = alert.findViewById(android.R.id.message)
    a.setTextSize(14f)
}