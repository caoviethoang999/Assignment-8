package com.example.hoangcv2_assiagnment.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hoangcv2_assiagnment.OnItemClickListener
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.RecyclerViewMargin
import com.example.hoangcv2_assiagnment.Status
import com.example.hoangcv2_assiagnment.adapter.RelatedItemAdapter
import com.example.hoangcv2_assiagnment.api.ProductService
import com.example.hoangcv2_assiagnment.model.Product
import com.example.hoangcv2_assiagnment.viewmodel.ProductRepository
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModel
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail.*
import java.util.*

class DetailFragment : Fragment(),OnItemClickListener {
    lateinit var viewModel: ProductViewModel
    private val productService = ProductService.getInstance()
    lateinit var list: MutableList<Product>
    lateinit var relatedItemAdapter: RelatedItemAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(toolBarDetail)
        appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addData()
        addDataToImageSlider()
        btnAddCart.setOnClickListener {
            txtPriceItem.text=elegantNumber.getNumber()
//            var sum=0
//            for (i in 0 until list.size) {
//                sum += list.get(i).price!!
//            }
//            txtPriceItem.text=sum.toString()
        }
    }


    fun addDataToImageSlider(){
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.tomato))
        imageList.add(SlideModel(R.drawable.grapes))
        imageList.add(SlideModel(R.drawable.pumpkins))
        image_slider.setImageList(imageList)
    }
    fun addData() {
        recylerViewProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        relatedItemAdapter = RelatedItemAdapter(this)
        recylerViewProduct.addItemDecoration(
            RecyclerViewMargin(
                1,
                resources.getDimensionPixelSize(R.dimen.recyclerView_item_marginRight)
            )
        )
        viewModel.getProduct()
        viewModel.productList.observe(viewLifecycleOwner,{
            relatedItemAdapter.getAll(it)
            recylerViewProduct.adapter = relatedItemAdapter
        })
//        var sum=0
//        for (i in 0 until list.size) {
//            sum += list[i].price!!
//        }
//        txtPriceItem.text=sum.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this, ProductViewModelFactory(ProductRepository(productService))).get(ProductViewModel::class.java)
        return inflater.inflate(R.layout.fragment_detail, container, false)
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
        if (status==Status.DETAIL) {
            val recylerFragment = DetailFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(R.id.fragment_container, recylerFragment)?.commit()
        }
    }
}