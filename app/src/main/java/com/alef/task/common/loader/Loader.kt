package com.alef.task.common.loader

import android.annotation.SuppressLint
import android.content.Context
import com.alef.task.App
import com.kaopiz.kprogresshud.KProgressHUD

@SuppressLint("StaticFieldLeak")
private var kProgressHUD: KProgressHUD? = null

fun helperShowLoader(ctx: Context?, message_txt: String) {
    var message = message_txt
    try {
        if (kProgressHUD == null) {
            kProgressHUD = KProgressHUD(ctx)
        } else {
            kProgressHUD?.dismiss()
            kProgressHUD = null
            message = """
                
                $message
                """.trimIndent()
            kProgressHUD = KProgressHUD(ctx)
            kProgressHUD?.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                ?.setDetailsLabel(message)
                ?.setCancellable(false)
                ?.setAnimationSpeed(3)
                ?.setDimAmount(0.5f)
                ?.setSize(App.dialogwidth, App.dialogHiegt)
        }
        try {
            kProgressHUD!!.show()
        } catch (e: Exception) {
            //
        }
    } catch (e: Exception) {
        //
    }
}

fun helperHideLoader() {
    try {
        kProgressHUD?.dismiss()
    } catch (e: Exception) {
    }
}