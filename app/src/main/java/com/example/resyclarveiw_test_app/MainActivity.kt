package com.example.resyclarveiw_test_app
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.databinding.DataBindingUtil
import com.example.resyclarveiw_test_app.databinding.HomePageBinding
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.Locale
import java.util.stream.IntStream.range
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding: HomePageBinding = DataBindingUtil
            .setContentView(this, R.layout.home_page)

        val users = mutableListOf<User>(
           User("A'laa Yasser","alaaMandour2024@gmail.com", 1),
           User("A'laa Yasser","alaaMandour2024@gmail.com", 2),
           User("A'laa Yasser","alaaMandour2024@gmail.com", 3),
           User("A'laa Yasser","alaaMandour2024@gmail.com", 4),
           User("A'laa Yasser","alaaMandour2024@gmail.com", 5),
           User("A'laa Yasser","alaaMandour2024@gmail.com", 6),
           User("A'laa Yasser","alaaMandour2024@gmail.com", 7),
           User("A'laa Yasser","alaaMandour2024@gmail.com", 8),
        )

        val user_adapter = UserAdapter(users)
        binding.rvUsers.adapter = user_adapter

        binding.toolbar.materialToolbar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.menu_Profile->{
                    Toast.makeText(this, R.string.profile, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_settings->{
                    Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_language->{
                    updateLocale(this, "ar")
                    true
                }
                R.id.search->{
                    Toast.makeText(this,R.string.search_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.navigationMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    Toast.makeText(this, R.string.home, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.gallery->{
                    Toast.makeText(this, R.string.gallery, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.slidShow->{
                    Toast.makeText(this, R.string.slideShow, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false
            }
        }

        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.favorites->{
                    Toast.makeText(this, R.string.favorites, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.profile->{
                    Toast.makeText(this, R.string.profile, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.settings->{
                    Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false
            }
        }


       binding.FAB.setOnClickListener{
           Snackbar.make(binding.coordinatorLayout,R.string.fab_clicked, Snackbar.LENGTH_SHORT)
               .show()
       }
    }

    fun updateLocale(context: Context, languageCode: String) {

        // locale  ar  direction

        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale)
            context.createConfigurationContext(config)
        } else {
            config.locale = locale
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }

        // Update layout direction
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale)
        }

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        //restart activity

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}

