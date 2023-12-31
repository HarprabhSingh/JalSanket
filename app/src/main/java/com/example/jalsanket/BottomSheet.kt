package com.example.jalsanket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jalsanket.data.FetchedData
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheet.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomSheet : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: customadapter // Declare the adapter as a property
    private lateinit var viewModel: ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)


        // Observe the LiveData from the ViewModel
//        viewModel.dataList.observe(viewLifecycleOwner, Observer { dataList ->
//            // Update the RecyclerView adapter with the new data
//            customAdapter = customadapter(hardcodedData)
//            recyclerView.adapter = customAdapter
//        })
        customAdapter = customadapter(hardcodedData)

        // Set the adapter for the RecyclerView
        recyclerView.adapter = customAdapter
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        recyclerView = view.findViewById(R.id.recycleView)

        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        // Inflate the layout for this fragment
        return view
    }

    companion object{
        val hardcodedData = mutableListOf(
            FetchedData("Pond Contamination", "Dirty Water",28.7076717,77.1233681,0,null)
            // Add more hardcoded items as needed
        )
    }
}