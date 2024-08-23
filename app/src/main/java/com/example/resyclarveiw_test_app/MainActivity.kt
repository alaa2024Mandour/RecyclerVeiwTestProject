package com.example.resyclarveiw_test_app
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.databinding.DataBindingUtil
import com.example.resyclarveiw_test_app.databinding.HomePageBinding
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding: HomePageBinding = DataBindingUtil
            .setContentView(this, R.layout.home_page)

        val users = mutableListOf<User>(
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
           User("A'laa Yasser","alaaMandour2024@gmail.com"),
        )

        val user_adapter = UserAdapter(users)
        binding.rvUsers.adapter = user_adapter

        binding.toolbar.material_toolbar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.menu_Profile->{
                   Toast.makeText(this, "@string/profile_clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_settings->{
                   Toast.makeText(this, "@string/settings_clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_language->{
                   Toast.makeText(this, "@string/language_clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search->{
                   Toast.makeText(this, "@string/search_clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false

            }
        }

     }
}
