package com.example.myapplication.shemajamebeli3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentBinding
import com.example.myapplication.databinding.GridItemBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.math.sqrt

class FragmentForGrid : Fragment(){
    private var _binding : FragmentBinding? = null
    private val binding get() = _binding!!
    val dataList = mutableListOf<CellState>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBinding.inflate(inflater, container, false)
        return binding.root
        val boardForRuntime = Array(sqrt(  dataList.size.toDouble()).toInt()) { Array(sqrt(  dataList.size.toDouble()).toInt()) {""} }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GridListAdapter(dataList) { winner ->
            if (winner( setUpBoardOfArray(5))  == "X") {
                binding.recyclerForGrid.visibility = View.GONE
                binding.startContainer.visibility = View.GONE
                binding.winner.visibility = View.VISIBLE
                binding.winner.setText("Winner is X !!!")
            } else if (winner(setUpBoardOfArray(5)) == "O") {
                binding.recyclerForGrid.visibility = View.GONE
                binding.startContainer.visibility = View.GONE
                binding.winner.visibility = View.VISIBLE
                binding.winner.setText("Winner is 0 !!!")
            }
        }
        var dimension = 3
        val gridLayout = GridLayoutManager(this.requireContext(), dimension)
        binding.recyclerForGrid.layoutManager = gridLayout
        binding.recyclerForGrid.adapter = adapter
        adapter.submitList(dataList.toList())

        binding.g3x3.setOnClickListener {

            dataList.clear()
            val tempList = setUpBoard(3)
            dataList.addAll(tempList)
            adapter.submitList(dataList.toList())
            binding.startContainer.visibility = View.GONE
            binding.recyclerForGrid.visibility = View.VISIBLE
        }

        binding.g4x4.setOnClickListener {
            dataList.clear()
            val tempList = setUpBoard(4)
            dataList.addAll(tempList)
            adapter.submitList(dataList.toList()) {
                gridLayout.spanCount = 4
            }

            binding.startContainer.visibility = View.GONE
            binding.recyclerForGrid.visibility = View.VISIBLE
        }

        binding.g5x5.setOnClickListener {
            dataList.clear()
            val tempList = setUpBoard(5)
            dataList.addAll(tempList)
            adapter.submitList(dataList.toList()) {
               gridLayout.spanCount = 5
            }

            binding.startContainer.visibility = View.GONE
            binding.recyclerForGrid.visibility = View.VISIBLE
        }



    }






    private fun setUpBoard(gridSize: Int): List<CellState> {
        return MutableList(gridSize * gridSize) { CellState(false) }
    }

    private fun setUpBoardOfArray(gridSize: Int): Array<Array<String>> {
        return Array(gridSize) { Array(gridSize) {""} }
    }


    private fun winner(board: Array<Array<String>>) :String{

        val _2dArray = Array(sqrt(  dataList.size.toDouble()).toInt()) { Array(sqrt(  dataList.size.toDouble()).toInt()) {""} }
        for (i in 0..<_2dArray.size) {
            for (j in 0..<_2dArray.size) {
                _2dArray[i][j] = if (dataList[i*j].isX == true) "X" else "O"
            }

        }

        val size = _2dArray.size
        for (i in 0 until size) {
            if ((0 until size).all { _2dArray[i][it] == _2dArray[i][0] && _2dArray[i][0] != ""}) return _2dArray[i][0]

            if ((0 until size).all { _2dArray[it][i] == _2dArray[0][i] && _2dArray[0][i] != ""}) return _2dArray[0][i]
        }

        if ((0 until size).all { _2dArray[it][it] ==  _2dArray[0][0] && _2dArray[0][0] !=""}) return _2dArray[0][0]

        if ((0 until size).all { _2dArray[it][size - it - 1] ==  _2dArray[0][size -1] && _2dArray[0][size -1] !=""}) return _2dArray[0][size -1]

        return ""
    }
}