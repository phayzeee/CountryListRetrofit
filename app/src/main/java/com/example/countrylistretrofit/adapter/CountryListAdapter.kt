package com.example.countrylistretrofit.adapter

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylistretrofit.R
import com.example.countrylistretrofit.model.CountryModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.country_list_row.view.*

class CountryListAdapter(val activity: Activity): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private var countryList: List<CountryModel>? = null

    fun setCountryList(countryList: List<CountryModel>?){
        this.countryList = countryList
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryListAdapter.MyViewHolder, position: Int) {
        holder.bind(countryList!!.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        if(countryList == null)return 0
        else return countryList?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val flag = view.flagImage
        val tvName = view.tvName
        val tvCapital = view.tvCapital
        val tvRegion = view.tvRegion

        fun bind(data: CountryModel, activity: Activity){
            tvName.text = data.name + "(" + data.postalCode + ")"
            tvCapital.text = "Capital: "+data.capital
            tvRegion.text = "Region: "+data.region

            GlideToVectorYou.justLoadImage(activity, Uri.parse(data.flag), flag)
        }
    }
}