package com.example.storeroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.storeroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSave.setOnClickListener{
            val store = StoreEntity(name = mBinding.etName.text.toString().trim())
//
//            Thread {
//                StoreApplication.database.storeDao().addStore(store)
//            }.start()
            mAdapter.add(store)
        }

        mBinding.btnSave.setOnClickListener {
            val store = StoreEntity(name = mBinding.etName.text.toString().trim())
            mAdapter.add(store)
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        mAdapter = StoreAdapter(mutableListOf(),this)
        mGridLayout = GridLayoutManager(this, 2)

        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    /*
    * OnClickListener
    * */
    override fun onClick(storeEntity: StoreEntity){

    }
}