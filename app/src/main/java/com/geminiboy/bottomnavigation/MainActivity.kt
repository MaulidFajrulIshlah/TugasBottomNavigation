package com.geminiboy.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.geminiboy.bottomnavigation.databinding.ActivityMainBinding
import com.geminiboy.bottomnavigation.fragment.HomeFragment
import com.geminiboy.bottomnavigation.fragment.ProfilFragment
import com.geminiboy.bottomnavigation.fragment.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.person -> replaceFragment(ProfilFragment())
                R.id.setting -> replaceFragment(SettingFragment())

                else -> {

                }

            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}