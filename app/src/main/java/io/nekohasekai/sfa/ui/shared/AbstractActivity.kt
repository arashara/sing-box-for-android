package io.nekohasekai.sfa.ui.shared

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.color.DynamicColors
import io.nekohasekai.sfa.R
import io.nekohasekai.sfa.ktx.getAttrColor


abstract class AbstractActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DynamicColors.applyToActivityIfAvailable(this)

        val colorSurfaceContainer =
            getAttrColor(com.google.android.material.R.attr.colorSurfaceContainer)
        window.statusBarColor = colorSurfaceContainer
        window.navigationBarColor = colorSurfaceContainer

        supportActionBar?.setHomeAsUpIndicator(AppCompatResources.getDrawable(
            this@AbstractActivity,
            R.drawable.ic_arrow_back_24
        )!!.apply {
            setTint(getAttrColor(com.google.android.material.R.attr.colorOnSurface))
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}