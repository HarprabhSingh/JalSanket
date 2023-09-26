package com.example.jalsanket

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jalsanket.data.ProblemData
import kotlinx.coroutines.Dispatchers
import java.io.File
import androidx.lifecycle.viewModelScope
import com.example.jalsanket.data.FetchedData
import com.example.jalsanket.network.JalApi
import com.example.jalsanket.network.JalApiService
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response



class ViewModel: ViewModel(){
    private val _dataList = MutableLiveData<List<FetchedData>>()
    val dataList: LiveData<List<FetchedData>> = _dataList
    fun sendMultipartData(problemData: ProblemData, imageFile: File) {
        Log.d("muneer","called")
        viewModelScope.launch ( Dispatchers.IO){
            try {
                val imagePart = MultipartBody.Part.createFormData(
                    "image",
                    imageFile.name,
                    imageFile.asRequestBody("image/*".toMediaTypeOrNull())
                )

                val response  = JalApi.retrofitService.uploadData(
                    problemData.title,
                    problemData.desc,
                    problemData.latitude,
                    problemData.longitude,
                    imagePart)
                Log.d("muneer",response.toString())

            } catch (e: Exception) {
                Log.d("muneer","Failure: ${e.message}")
            }
        }
    }
    fun fetchData(){
        viewModelScope.launch {
            try {
                val data = JalApi.retrofitService.getData()
                _dataList.postValue(data)
            } catch (e: Exception) {
                // Handle any errors that may occur during the API request
                // You can log the error or handle it as needed
            }
        }
    }
}