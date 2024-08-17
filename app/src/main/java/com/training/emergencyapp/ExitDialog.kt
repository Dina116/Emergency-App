package com.training.emergencyapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExitDialog:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(activity)
        builder
            .setIcon(android.R.drawable.ic_menu_close_clear_cancel)
            .setTitle(getString(R.string.exit))
            .setMessage(getString(R.string.do_you_want_to_exit_the_app))
            .setPositiveButton(getString(R.string.ok)) { _, _ -> activity?.finish() }
            .setNegativeButton(getString(R.string.cancel)){ dialog, _->dialog.dismiss()}
        return builder.create()

    }
}