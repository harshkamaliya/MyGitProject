package com.example.mygit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygit.R
import com.example.mygit.model.PullRequest
import com.example.mygit.util.getProgressDrawable
import com.example.mygit.util.loadImage

import kotlinx.android.synthetic.main.item_list.view.*

class PullRequestAdapter(var pullRequest: ArrayList<PullRequest>):RecyclerView.Adapter<PullRequestAdapter.PullListRequestViewHolder>() {

   fun updatePullRequestList(newPullRequest: List<PullRequest>) {
      pullRequest.clear()
      pullRequest.addAll(newPullRequest)
      notifyDataSetChanged()
   }

   override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = PullListRequestViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
   )

   override fun getItemCount() = pullRequest.size

   override fun onBindViewHolder(holder: PullListRequestViewHolder, position: Int) {
      holder.bind(pullRequest[position])
   }

   class PullListRequestViewHolder(view: View): RecyclerView.ViewHolder(view) {
      private val title = view.title
      private val created_date = view.created_date
      private val closed_date = view.closed_date
      private val imageView = view.imageView
      private val username = view.user
      private val progressDrawable = getProgressDrawable(view.context)


      fun bind(pullRequest: PullRequest) {
         title.text = pullRequest.title
         created_date.text = pullRequest.created_date
         closed_date.text = pullRequest.closed_date
         username.text = pullRequest.user.name
         imageView.loadImage(pullRequest.user.avatar_url, progressDrawable)
      }
   }
}