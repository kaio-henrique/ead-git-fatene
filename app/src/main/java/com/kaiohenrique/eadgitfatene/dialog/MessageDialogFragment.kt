package com.kaiohenrique.eadgitfatene.dialog

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.kaiohenrique.eadgitfatene.R
import kotlinx.android.synthetic.main.fragment_dialog_message.*


/**
 *
 *@author Kaio Henrique on 24/04/2019
 *
 */
class MessageDialogFragment : DialogFragment() {

    private val TITLE = "title"
    private val MESSAGE = "message"

    private val title by lazy {
        arguments?.getString(TITLE)
    }

    private val message by lazy {
        arguments?.getString(MESSAGE)
    }

    private var onDismiss: (() -> Unit)? = null

    override fun getTheme(): Int {
        return R.style.AppTheme_Dialog
    }

    companion object {
        fun newInstance(title: String, message: String): MessageDialogFragment {
            val frag = MessageDialogFragment()
            val bundle = Bundle()

            bundle.putString(frag.TITLE, title)
            bundle.putString(frag.MESSAGE, message)

            frag.arguments = bundle

            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.fragment_dialog_message, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        fillFields()
        actionOk.setOnClickListener(::onClickOk)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismiss?.invoke()
    }

    private fun fillFields() {
        titleDialog.text = title
        messageDialog.text = message
    }

    private fun onClickOk(view: View) {
        when (view.id) {
            actionOk.id -> {
                onDismiss?.invoke()
                dismiss()
            }
        }
    }

    fun onDismiss(f: () -> Unit) {
        onDismiss = f
    }

}