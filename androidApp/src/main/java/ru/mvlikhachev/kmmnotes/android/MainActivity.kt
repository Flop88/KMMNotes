package ru.mvlikhachev.kmmnotes.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mvlikhachev.kmmnotes.Greeting
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.mvlikhachev.kmmnotes.di.AppSDK
import ru.mvlikhachev.kmmnotes.di.Configuration
import ru.mvlikhachev.kmmnotes.di.PlatformType
import ru.mvlikhachev.kmmnotes.features.auth_module.auth

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = Greeting().getName("Android")

        AppSDK.init(
            configuration = Configuration(
                platformType = PlatformType.Android("1.0", "1")
            )
        )

        GlobalScope.launch {
            AppSDK.auth.authRepository.signUp("Flop88", "1234qwer")
        }
    }
}
