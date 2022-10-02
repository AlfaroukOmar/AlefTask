package com.alef.task.presentation.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alef.domain.entities.ProductEntity
import com.alef.task.R
import com.alef.task.common.ItemClicked
import com.alef.task.common.loader.helperHideLoader
import com.alef.task.common.loader.helperShowLoader
import com.alef.task.databinding.FragmentFavouriteBinding
import com.alef.task.presentation.adapter.FavouriteAdapter
import com.alef.task.presentation.viewmodel.FoodViewModel

class FavouriteFragment : Fragment(), ItemClicked {

    lateinit var binding: FragmentFavouriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var viewModel: FoodViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = (activity as MainActivity).foodViewModel
    }

    val adapter = FavouriteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment


        adapter.itemClicked = this

        binding.productsRecyclerView.showShimmerAdapter()

        binding.productsRecyclerView.layoutManager = LinearLayoutManager(requireContext())


        observePart()

        viewModel.getFoodList()


        return binding.root
    }

    private fun observePart() {
        viewModel.FoodListState.observe(requireActivity()) {
            when (it.status) {
                com.alef.task.common.Status.SUCCESS -> {
                    helperHideLoader()
                    binding.productsRecyclerView.adapter = adapter
                    adapter.setArrayList(it.data as ArrayList<ProductEntity>)
                }
                com.alef.task.common.Status.LOADING -> {
                    helperShowLoader(requireContext(), getString(R.string.please_wait))
                }
                com.alef.task.common.Status.ERROR -> {
                    helperHideLoader()
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    override fun clickItemFav(item: ProductEntity, isFav: Boolean) {
        viewModel.ChangeFavouriteStates(item, isFav)
    }

}