package com.example.hoangcv2_assiagnment.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hoangcv2_assiagnment.*
import com.example.hoangcv2_assiagnment.adapter.ProductAdapter
import com.example.hoangcv2_assiagnment.databinding.FragmentProductBinding
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProductFragment : DaggerFragment(),OnItemClickListener {

    @Inject
    lateinit var viewModel: ProductViewModel

    private lateinit var productAdapter: ProductAdapter

    private var title:String?=null

    private lateinit var binding:FragmentProductBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(binding.toolBarProduct)
        appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        passData()
        addDataVegetables()
        addDataFruits()
    }

    private fun passData(){
        val bundle = this.arguments
        if (bundle != null) {
            title = bundle.getString("name")
        }
        binding.txtCategories.text=title
    }
    private fun addDataVegetables() {
        binding.recylerViewProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        productAdapter = ProductAdapter(this)
        binding.recylerViewProduct.addItemDecoration(
            RecyclerViewProductMargin(
                2,
                resources.getDimensionPixelSize(R.dimen.recyclerView_product_marginTop)
            )
        )
        if(title.equals(Constrants.CATEGORY_VEGETABLES)) {
            viewModel.getProductByCategory(1)
            viewModel.productList.observe(viewLifecycleOwner, {
                productAdapter.getAll(it)
                binding.recylerViewProduct.adapter = productAdapter
            })
        }
    }
    private fun addDataFruits() {
        binding.recylerViewProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        productAdapter = ProductAdapter(this)
        binding.recylerViewProduct.addItemDecoration(
            RecyclerViewProductMargin(
                2,
                resources.getDimensionPixelSize(R.dimen.recyclerView_product_marginTop)
            )
        )
        if(title.equals(Constrants.CATEGORY_FRUITS)) {
            viewModel.getProductByCategory(2)
            viewModel.productList.observe(viewLifecycleOwner, {
                productAdapter.getAll(it)
                binding.recylerViewProduct.adapter = productAdapter
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding= FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_shopping, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(position: Int,status:Status) {
        if (status== Status.DETAIL) {
            val recyclerFragment = DetailFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(R.id.fragment_container, recyclerFragment)?.commit()
        }
    }
}