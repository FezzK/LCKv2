package com.example.lckv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.lckv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var vBinding : ActivityMainBinding? = null
    private val binding get() = vBinding!!

    var viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewList.add(layoutInflater.inflate(R.layout.fragment_main, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_match, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_rank, null))

        binding.viewPager.adapter = pagerAdapter()

        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> binding.navigationView.selectedItemId = R.id.main
                    1 -> binding.navigationView.selectedItemId = R.id.match
                    2 -> binding.navigationView.selectedItemId = R.id.rank
                }
            }
        })

        binding.navigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.main -> binding.viewPager.setCurrentItem(0)
                R.id.match -> binding.viewPager.setCurrentItem(1)
                R.id.rank -> binding.viewPager.setCurrentItem(2)
            }
            return@setOnItemSelectedListener true

        }
    }

    inner class pagerAdapter : PagerAdapter() {
        override fun getCount() = viewList.size

        override fun isViewFromObject(view: View, `object`: Any) = view == `object`

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var curView = viewList[position]
            binding.viewPager.addView(curView)
            return curView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            binding.viewPager.removeView(`object` as View)
        }

    }

    override fun onDestroy() {
        vBinding = null

        super.onDestroy()
    }
}