package com.example.svdlauncher

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerAdapter(getAllApps())

    }

    private fun getAllApps(): MutableList<String> {
        val installedApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        val apps = mutableListOf<String>()
        for (app in installedApps) {
            apps.add(app.packageName)
        }

        return apps.toMutableList()
    }

}