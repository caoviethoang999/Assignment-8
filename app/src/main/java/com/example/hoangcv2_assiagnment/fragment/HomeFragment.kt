package com.example.hoangcv2_assiagnment.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hoangcv2_assiagnment.*
import com.example.hoangcv2_assiagnment.adapter.CategoryAdapter
import com.example.hoangcv2_assiagnment.adapter.TopProductAdapter
import com.example.hoangcv2_assiagnment.api.ProductService
import com.example.hoangcv2_assiagnment.model.Category
import com.example.hoangcv2_assiagnment.model.Product
import com.example.hoangcv2_assiagnment.viewmodel.ProductRepository
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModel
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList


class HomeFragment : Fragment(), OnItemClickListener {
    var list:MutableList<Category> = ArrayList<Category>()
    lateinit var viewModel: ProductViewModel
    private val productService = ProductService.getInstance()
    lateinit var topProductAdapter: TopProductAdapter
    lateinit var categoryAdapter: CategoryAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(toolBarHome)
        val toggle = ActionBarDrawerToggle(
            activity, drawer_layout, toolBarHome,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        addDataTopProduct()
        addDataCategoryItem()
    }

    fun addDataTopProduct() {
        recylerViewTopProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        topProductAdapter = TopProductAdapter(this)
        recylerViewTopProduct.addItemDecoration(
            RecyclerViewProductMargin(
                2,
                resources.getDimensionPixelSize(R.dimen.recyclerView_topproduct_marginTop)
            )
        )
        viewModel.getProduct()
        viewModel.productList.observe(viewLifecycleOwner,{

            topProductAdapter.getAll(it)
            recylerViewTopProduct.adapter = topProductAdapter
        })
    }

    fun addDataCategoryItem() {
        recylerViewItem.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoryAdapter = CategoryAdapter(this)
        recylerViewItem.addItemDecoration(
            RecyclerViewMargin(
                1,
                resources.getDimensionPixelSize(R.dimen.recyclerView_item_marginRight)
            )
        )
        viewModel.getCategory()
        viewModel.categoryList.observe(viewLifecycleOwner,{
            list=it
            categoryAdapter.getAll(list)
            recylerViewItem.adapter = categoryAdapter
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this, ProductViewModelFactory(ProductRepository(productService))).get(ProductViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_shopping, menu)
    }
    override fun onItemClick(position: Int,status:Status) {
        if (status== Status.CATEGORY ) {
            val recylerFragment = ProductFragment()
            val bundle = Bundle()
            bundle.putString("name", list[position].categoryName)
            recylerFragment.setArguments(bundle)
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(R.id.fragment_container, recylerFragment)?.commit()
        }else if (status== Status.DETAIL) {
            val recylerFragment = DetailFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(R.id.fragment_container, recylerFragment)?.commit()
        }
    }
}