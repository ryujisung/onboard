package com.example.socialc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ramotion.paperonboarding.PaperOnboardingPage
import kotlinx.android.synthetic.main.activity_onboard.*

class OnboardActivity : AppCompatActivity() {
    private var vpAdapter: FragmentStatePagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)

        val viewpager = findViewById<ViewPager>(R.id.Viewpager)
        vpAdapter = CustomPagerAdapter(supportFragmentManager)
        viewpager.adapter = vpAdapter

        indicator.setViewPager(viewpager)

    }

    class CustomPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val PAGENUMBER = 4

        override fun getCount(): Int {
            return PAGENUMBER
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> OnboardFragment.newInstance(R.drawable.cloc, "test 00")
                1 -> OnboardFragment.newInstance(R.drawable.globalwarmin, "test 01")
                2 -> OnboardFragment.newInstance(R.drawable.gear, "test 02")
                3 -> OnboardFragment.newInstance(R.drawable.startu, "test 03")
                else -> OnboardFragment.newInstance(R.drawable.cloc, "page00")
            }
        }
    }
}