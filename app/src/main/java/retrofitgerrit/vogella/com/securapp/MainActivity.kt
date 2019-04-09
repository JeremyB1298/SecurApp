package retrofitgerrit.vogella.com.securapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val itemList: Array<String>
        get() = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

    private var buttons: List<Button>? = null
    private val BUTTON_IDS = intArrayOf(
                R.id.button,
                R.id.button1,
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8,
                R.id.button9
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this);

        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference
        val passwordValid : DatabaseReference = myRef.child("passwordValid")

        buttons = ArrayList<Button>()

        for (id in BUTTON_IDS) {
            val button = findViewById(id) as Button
            button.setOnClickListener(object: View.OnClickListener {
                override fun onClick(view: View): Unit {
                    textView1.text = textView1.text.toString() + "" + (view as Button).text.toString()
                }
            })
            (buttons as ArrayList<Button>).add(button)
        }

        val bValid : Button = findViewById(R.id.bValid)

        bValid.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {

                if (textView1.text == "11111") {
                    passwordValid.setValue("ON")
                }

            }
        })

        val textView1: TextView = findViewById(R.id.textView1)
        textView1.text = ""
        /*val button1 : Button = findViewById(R.id.button1)
        val button2 : Button = findViewById(R.id.button2)

        val textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)

        passwordValid.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                Log.v("file", "Failed to read value.", error.toException())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("file","Value is: " + value)
                textView1.text = value.toString()
            }

        })

        button1.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {

                passwordValid.setValue("ON")

            }
        })

        button2.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {

                passwordValid.setValue("OFF")

            }
        })*/

    }

}
