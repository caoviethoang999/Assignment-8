package com.example.hoangcv2_assiagnment.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hoangcv2_assiagnment.OnItemClickListener
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.RecyclerViewMargin
import com.example.hoangcv2_assiagnment.Status
import com.example.hoangcv2_assiagnment.adapter.RelatedItemAdapter
import com.example.hoangcv2_assiagnment.databinding.FragmentDetailBinding
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModel
import dagger.android.support.DaggerFragment
import java.util.*
import javax.inject.Inject

class DetailFragment : DaggerFragment(),OnItemClickListener {

    @Inject
    lateinit var viewModel: ProductViewModel

    private lateinit var relatedItemAdapter: RelatedItemAdapter

    private lateinit var binding:FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(binding.toolBarDetail)
        appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addData()
        addDataToImageSlider()
        binding.btnAddCart.setOnClickListener {
            binding.txtPriceItem.text=binding.elegantNumber.getNumber()
//            var sum=0
//            for (i in 0 until list.size) {
//                sum += list.get(i).price!!
//            }
//            txtPriceItem.text=sum.toString()
        }
    }


    private fun addDataToImageSlider(){
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.tomato))
        imageList.add(SlideModel(R.drawable.grapes))
        imageList.add(SlideModel(R.drawable.pumpkins))
        binding.imageSliderTest.setImageList(imageList)
    }
    private fun addData() {
        binding.recylerViewProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        relatedItemAdapter = RelatedItemAdapter(this)
        binding.recylerViewProduct.addItemDecoration(
            RecyclerViewMargin(
                1,
                resources.getDimensionPixelSize(R.dimen.recyclerView_item_marginRight)
            )
        )
        viewModel.getProduct()
        viewModel.productList.observe(viewLifecycleOwner,{
            relatedItemAdapter.getAll(it)
            binding.recylerViewProduct.adapter = relatedItemAdapter
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
    ): View {
        setHasOptionsMenu(true)
        binding= FragmentDetailBinding.inflate(inflater, container, false)
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
        if (status==Status.DETAIL) {
            val recyclerFragment = DetailFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(R.id.fragment_container, recyclerFragment)?.commit()
        }
    }
}