package retrofitgerrit.vogella.com.securapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.Observer
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.splash_screen)

        FirebaseApp.initializeApp(this);

        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference
        val badgeValid : DatabaseReference = myRef.child("badgeValid")
        badgeValid.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.v("file", "Failed to read value.", error.toException())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("file","Value is: " + value)
                if (value == "ON") {
                    start()
                }
            }

        })
    }

    private fun start() {
        startActivity(Intent(this@SplashScreen, MainActivity::class.java))

    }
}


