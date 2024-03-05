package uz.bnabiyev.realtimefirebase.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.bnabiyev.realtimefirebase.databinding.ItemRvBinding
import uz.bnabiyev.realtimefirebase.models.User

class UserAdapter(private val list: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {
    inner class Vh(private val itemRvBinding: ItemRvBinding) :
        RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(user: User) {
            itemRvBinding.tv.text = user.displayName
            Picasso.get().load(user.photoUrl).into(itemRvBinding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}