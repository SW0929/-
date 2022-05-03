package com.example.swpui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private val pieChart: PieChart by lazy {
        findViewById(R.id.pieChart)
    }

    private val mealViewPager2: ViewPager2 by lazy {
        findViewById(R.id.mealViewPager2)
    }

    private val calorieTextView: TextView by lazy {
        findViewById(R.id.calorieTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart.setUsePercentValues(true)

        mealViewPager2.adapter = MealPagerAdapter2(
            listOf(
                Meal("아침",
                "김치찌개"),
                Meal("점심",
                    "짜장면"),
                Meal("저녁",
                    "치킨")
            )
        )


        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(15f, "단백질"))
        entries.add(PieEntry(20f, "탄수화물"))
        entries.add(PieEntry(30f, "지방"))
        entries.add(PieEntry(20f, "나트륨"))
        entries.add(PieEntry(15f, "당류"))

        val colorsitems = java.util.ArrayList<Int>()
        for(c in ColorTemplate.VORDIPLOM_COLORS)colorsitems.add(c)
        for(c in ColorTemplate.JOYFUL_COLORS)colorsitems.add(c)
        for(c in ColorTemplate.LIBERTY_COLORS)colorsitems.add(c)
        colorsitems.add(ColorTemplate.getHoloBlue())
        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.apply {
            colors = colorsitems
            valueTextColor = Color.BLACK
            valueTextSize = 16f
        }
        val pieData = PieData(pieDataSet)
        pieChart.apply {
            data = pieData
            description.isEnabled = false
            isRotationEnabled = false
            centerText = "영양성분"
            setEntryLabelColor(Color.BLACK)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }

    }

}