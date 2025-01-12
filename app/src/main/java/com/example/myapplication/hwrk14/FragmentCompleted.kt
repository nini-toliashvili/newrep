package com.example.myapplication.hwrk14

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFoCompletedBinding
import com.example.myapplication.databinding.FragmentForActiveBinding
import java.util.UUID

class FragmentCompleted: Fragment() {


    private var _binding : FragmentFoCompletedBinding? = null
    private val binding get() = _binding!!

    private val activeOrdersList = mutableListOf(
        ListItems.CompletedOrder(UUID.randomUUID(), "Modern Wingback", "#000000", "Black", 3, 280.00F, img = R.drawable.blazer),
        ListItems.CompletedOrder(UUID.randomUUID(), "Wooden Chair", "#785746", "Brown", 2, 140.00F, img = R.drawable.boots3),
        ListItems.CompletedOrder(UUID.randomUUID(), "Mirrored Reflector", "#000000", "Black", 3, 280.00F, img = R.drawable.boots2),
        ListItems.CompletedOrder(UUID.randomUUID(), "Mini BookShelf", "#785746", "Brown", 3, 280.00F, img = R.drawable.boots1)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoCompletedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        binding.activeButton.setOnClickListener {

            navigateToActiveOrders()
        }
    }


    private fun navigateToActiveOrders() {
        val action = FragmentCompletedDirections.completedToActive()
        findNavController().navigate(action)

    }


    private fun setUpAdapter() {
        val adapter = ListAdapterOrders(activeOrdersList) { item ->

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.recyclerView.adapter = adapter
        adapter.submitList(activeOrdersList as List<ListItems>?)

    }}