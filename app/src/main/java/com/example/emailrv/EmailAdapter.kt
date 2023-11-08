package com.example.emailrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EmailAdapter(private val dataSet: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar: TextView
        val username: TextView
        val time: TextView
        val message: TextView
        val selected: ImageView


        init {
            // Define click listener for the ViewHolder's View
            avatar = view.findViewById<TextView>(R.id.avatar)
            username = view.findViewById<TextView>(R.id.username)
            message = view.findViewById<TextView>(R.id.message)
            time = view.findViewById<TextView>(R.id.time)
            selected = view.findViewById<ImageView>(R.id.selected)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val currentItem = dataSet[position]

        viewHolder.username.text = currentItem.username
        viewHolder.message.text = currentItem.message
        viewHolder.time.text = currentItem.time


        val firstLetter = currentItem.username.first().uppercaseChar().toString()
        viewHolder.avatar.text = firstLetter

        if (currentItem.selected) {
            viewHolder.selected.setBackgroundResource(R.drawable.yellow_star_background) // Chỉnh màu nền thành màu vàng
        } else {
            viewHolder.selected.setBackgroundResource(R.drawable.white_star_background) // Màu nền mặc định là trắng
        }

        viewHolder.selected.setOnClickListener {
            // Đảo ngược trạng thái selected
            currentItem.selected = !currentItem.selected

            // Cập nhật lại trạng thái cho item hiện tại
            if (currentItem.selected) {
                viewHolder.selected.setBackgroundResource(R.drawable.yellow_star_background) // Nếu selected là true, đổi màu nền thành màu vàng
            } else {
                viewHolder.selected.setBackgroundResource(R.drawable.white_star_background) // Nếu selected là false, đổi màu nền về trắng
            }
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
