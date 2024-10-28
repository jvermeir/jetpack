package nl.vermeir.shopapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import nl.vermeir.shopapp.ui.theme.ShopAppTheme

class MenuViewModel : ViewModel() {
    val categories: SnapshotStateList<CategoryData> = mutableStateListOf(
        CategoryData(1, "Category 1", 1),
        CategoryData(2, "Category 2", 2),
        CategoryData(3, "Category 3", 3)
    )
}

@Composable
fun MainMenu(
    modifier: Modifier = Modifier,
    onCategoriesClick: () -> Unit = {},
    viewModel: MenuViewModel = viewModel()
) {
    val categories = viewModel.categories

    Column {
        Text(
            text = "Top",
            modifier = modifier
        )
        Button(onClick = onCategoriesClick) {
            Text("Categories")
        }
        Button(onClick = { onClick() }) {
            Text("Ingredients")
        }
        Text(
            text = "Bottom",
            modifier = modifier
        )
    }
}

fun onClick() {
    println("Button clicked")
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    ShopAppTheme {
        MainMenu()
    }
}