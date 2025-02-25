package com.omarkarimli.intelliflow.ui.explore

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omarkarimli.intelliflow.domain.models.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

class ExploreViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<ProductModel>>(emptyList())
    val products: StateFlow<List<ProductModel>> = _products

    private val _isLoading = MutableStateFlow(false) // Loading state
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null) // Error message
    val error: StateFlow<String?> = _error

    fun searchProducts(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            _error.value = null // Reset error message

            try {
                val searchUrl = "https://www.google.com/search?q=$query+buy"
                val doc = Jsoup.connect(searchUrl).get()

                // Debugging: Log the raw HTML response
                Log.d("ExploreViewModel", "HTML Response: ${doc.outerHtml()}")

                val productsList = mutableListOf<ProductModel>()
                doc.select("div.tF2Cxc").forEach { element ->
                    val title = element.select("h3").text()
                    val link = element.select("a").attr("href")
                    val price = "Check on Website"
                    val imageUrl = "https://via.placeholder.com/150"

                    productsList.add(ProductModel(title, price, imageUrl, link))
                }

                // Debugging: Log the products list
                Log.d("ExploreViewModel", "Found products: ${productsList.size}")

                // Check if products are found
                if (productsList.isEmpty()) {
                    _error.value = "No products found for your search."
                }

                _products.value = productsList
            } catch (e: Exception) {
                _error.value = "An error occurred: ${e.message}"
                Log.e("ExploreViewModel", "Error: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}
