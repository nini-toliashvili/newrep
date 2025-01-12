package com.example.myapplication.hwrk14

import android.os.Bundle
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentChatBinding
import com.example.myapplication.databinding.FragmentForActiveBinding
import java.util.UUID


class FragmentActive: Fragment() {


    private var _binding : FragmentForActiveBinding? = null
    private val binding get() = _binding!!

    private val activeOrdersList = mutableListOf(
        ListItems.ActiveOrder(UUID.randomUUID(), "Modern Wingback", "#000000", "Black", 3, 280.00f, img = R.drawable.blazer),
        ListItems.ActiveOrder(UUID.randomUUID(), "Wooden Chair", "#785746", "Brown", 2, 140.00f, img = R.drawable.boots3),
        ListItems.ActiveOrder(UUID.randomUUID(), "Mirrored Reflector", "#000000", "Black", 3, 280.00f, img = R.drawable.boots2),
        ListItems.ActiveOrder(UUID.randomUUID(), "Mini BookShelf", "#785746", "Brown", 3, 280.00f, img = R.drawable.boots1)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForActiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()

        binding.completedButton.setOnClickListener {
            navigateToCompletedOrders()
        }
    }


private fun navigateToCompletedOrders() {
    val action = FragmentActiveDirections.activeToCompleted()
    findNavController().navigate(action)

}

    private fun setUpAdapter() {
        val adapter = ListAdapterOrders(activeOrdersList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.recyclerView.adapter = adapter
        adapter.submitList(activeOrdersList as List<ListItems>?)

    }}