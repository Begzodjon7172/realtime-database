package uz.bnabiyev.realtimefirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import uz.bnabiyev.realtimefirebase.adapters.UserAdapter
import uz.bnabiyev.realtimefirebase.databinding.ActivityUsersBinding
import uz.bnabiyev.realtimefirebase.models.User

private const val TAG = "UsersActivity"

class UsersActivity : AppCompatActivity() {
    private val binding by lazy { ActivityUsersBinding.inflate(layoutInflater) }

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var list: ArrayList<User>
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users")

        list = ArrayList()
        userAdapter = UserAdapter(list)
        binding.rv.adapter = userAdapter

        // database dan malumotlarni o'qib olish
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                val children = snapshot.children
                children.forEach {
                    val user = it.getValue(User::class.java)
                    if (user != null) {
                        list.add(user)
                    }
                }
                userAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }
}