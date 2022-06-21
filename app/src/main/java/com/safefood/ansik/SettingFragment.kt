package com.safefood.ansik

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.TypedValue
import android.view.*
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.preference.*

class SettingFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setting,rootKey)

        val idPreference:EditTextPreference?= findPreference("idSetting")
        idPreference?.title = "ID 변경"
        //idPreference?.summary = "ID를 변경할 수 있습니다."
        //idPreference?.summaryProvider = EditTextPreference.SimpleSummaryProvider.getInstance()
        idPreference?.summaryProvider = Preference.SummaryProvider<EditTextPreference> {
            preference ->
                val text = preference.text
                if(TextUtils.isEmpty(text)){
                    "ID 설정이 되지 않았습니다."
                }
                else{
                    "$text"
                }
        }

        //배경색상테마설정
        val bgColorPreference:ListPreference? = findPreference("bgColorSetting")
        bgColorPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()


        val filterPreference : MultiSelectListPreference? = findPreference("allergySetting")
        filterPreference?.title = "알러지 필터 설정"
        //filterPreference?.summary = "알러지 필터를 설정할 수 있습니다."
        //filterPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

        filterPreference?.summaryProvider = Preference.SummaryProvider<MultiSelectListPreference> {
                preference ->
            val filtertext = arrayOf(preference)
            if(TextUtils.isEmpty(filtertext.toString())){
                "filter 설정이 되지 않았습니다."
            }
            else{
                "$filtertext"
            }
        }


    }


    //색상
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Get the Theme specific color
        val typedValue = TypedValue()
        val theme = requireContext().theme

        /*R.attr.colorBackgroundScreenBody is my own attr from attrs.xml file,
        you can directly use R.color.red - Or any color from your colors.xml
        file if you do not have multi-theme app.*/
        theme.resolveAttribute(R.xml.setting, typedValue, true)
        @ColorInt val color = typedValue.data

        view.setBackgroundColor(Color.parseColor("#1F1E1E"))

        super.onViewCreated(view, savedInstanceState)
    }



}
