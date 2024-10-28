package nl.vermeir.shopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import nl.vermeir.shopapp.ui.theme.ShopAppTheme

data class CategoryData(val id: Int, val name: String, val shopOrder: Int)

class CategoriesActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopAppTheme {
                Categories(activity = this)
            }
        }
    }
}

// TODO: save updated category data
@Co mposable
fun Categories(modifier: Modifier = Modifier, viewModel: MenuViewModel = viewModel(), activity: ComponentActivity) {
    val categories = viewModel.categories

    Column {
        Text(
            text = "Top",
            modifier = modifier
        )
        categories.forEach { category ->
            Category(category = category)
//            Button(onClick = { onClick() }) {
//                Text(category.name)
//            }
        }
        Button(onClick = { activity.finish() }) {
            Text("Back to Main Menu")
        }
//        Button(onClick = { onClick() }) {
//            Text("Categories")
//        }
//        Button(onClick = { onClick() }) {
//            Text("Ingredients")
//        }
        Text(
            text = "Bottom",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesPreview() {
    ShopAppTheme {
        Categories(activity = object : ComponentActivity() {})
    }
}