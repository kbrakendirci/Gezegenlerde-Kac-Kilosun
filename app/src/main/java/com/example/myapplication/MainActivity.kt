package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener{

    val KILO_TO_POUND = 2.2045
    val MARS = 0.38
    val POUND_TO_KILO = 0.45359237
    val VENUS = 0.91
    val MERKUR =0.378
    val JUPITER =2.528
    val SATURN=1.064
    val GUNES =27.072


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbVenüs.setOnClickListener(this)
        cbMars.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)


       /* bthesapla.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.e("Emre","Butona Basıldı")

            }

        })*/

      /*  bthesapla.setOnClickListener {
                var kullaniciAgirlikPound = kiloToPound(kullanici.toString().toDouble())
                var marstakiAgirlikPound = kullaniciAgirlikPound * MARS
                var marstakiAgirlikKilo = poundToKilo(marstakiAgirlikPound)

                tvSonuc.text = marstakiAgirlikKilo.formatla(2).toString()
        }
*/
    }
    fun kiloToPound(kilo : Double) : Double {
        return kilo * KILO_TO_POUND
    }

    fun  poundToKilo(pound : Double) : Double {
        return pound * POUND_TO_KILO
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean=v.isChecked
        var kullaniciKilo = hesapla.text.toString().toDouble()
        var kullaniciPound = kiloToPound(kullaniciKilo)
        if(!TextUtils.isEmpty(hesapla.text.toString())) {
            var kullaniciKilo = hesapla.text.toString().toDouble()
            var kullaniciPound = kiloToPound(kullaniciKilo)

            when (v.id) {
                R.id.cbMars -> if (isChecked) {
                    cbJupiter.isChecked=false
                    cbVenüs.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound, v)

                }
                R.id.cbVenüs -> if (isChecked ) {
                    cbJupiter.isChecked=false
                    cbMars.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound, v)
                }
                R.id.cbJupiter -> if (isChecked) {
                    cbMars.isChecked=false
                    cbVenüs.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound, v)
                }
            }

        }
    }

    fun hesaplaAgirlikPound(pound:Double, checkBox: CheckBox){

        var sonuc : Double = 0.0

        when(checkBox.id){

            R.id.cbMars -> sonuc = pound * MARS
            R.id.cbJupiter -> sonuc = pound * JUPITER
            R.id.cbVenüs -> sonuc = pound * VENUS
            else -> sonuc = 0.0
        }

        var sonucToKilo = poundToKilo(sonuc)
        tvSonuc.text=sonucToKilo.formatla(2)

    }


    fun Double.formatla(kacTaneRakam:Int) = java.lang.String.format("%.${kacTaneRakam}f",this)
}