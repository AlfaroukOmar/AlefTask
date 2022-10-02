package com.alef.task.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ParentAdapter<Holder : RecyclerView.ViewHolder?, M> :
    RecyclerView.Adapter<Holder>() {
    private var arrayList = ArrayList<M>()
    lateinit var mContext: Context
    private val _layout = 0
    var viewHolder: Holder? = null
    abstract fun get_layout(): Int
    abstract fun getViewHolder(v: View?): Holder
    fun setArrayList(arrayList: ArrayList<M>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    fun remove(item : M)
    {
        arrayList.remove(item)
        notifyDataSetChanged()
    }

    fun getItem(pos: Int): M? {
        return arrayList[pos]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        mContext = parent.context
        val v = LayoutInflater.from(mContext).inflate(get_layout(), parent, false)
        return getViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}