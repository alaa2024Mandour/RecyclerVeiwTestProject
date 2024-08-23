package com.example.resyclarveiw_test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var users : List<User>): RecyclerView.Adapter<UserAdapter.UserVeiwHolder>(){

    class UserVeiwHolder(var row : View) : RecyclerView.ViewHolder(row){
        //hold views
        //create objects of textViews
        val tvName = row.findViewById<TextView>(R.id.tv_name)
        val tvEmail = row.findViewById<TextView>(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVeiwHolder {
        //convert xml file to view object and sent it to view holder
        val layout = LayoutInflater.from(parent.context /*parent -> RecyclerView*/).inflate(R.layout.item_user, parent, false)
        return UserVeiwHolder(layout)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserVeiwHolder, position: Int) {
        // bind data into views
        val user = users.get(position)
        holder.tvName.text=user.name
        holder.tvEmail.text=user.email
    }

}