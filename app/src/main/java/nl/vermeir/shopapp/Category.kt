package nl.vermeir.shopapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import nl.vermeir.shopapp.ui.theme.ShopAppTheme

@Composable
fun Category(
    category: CategoryData,
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = viewModel()
) {
    var (name, setName) = remember { mutableStateOf(category.name) }
    var (shopOrder, setShopOrder) = remember { mutableStateOf(category.shopOrder.toString()) }

    Row(modifier = modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = {
               setName(it)
            },
            modifier = modifier
                .padding(end = 16.dp)
                .fillMaxWidth(0.5f)
        )
        TextField(
            value = shopOrder,
            onValueChange = {
                setShopOrder(it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier
                .padding(end = 16.dp)
                .fillMaxWidth(0.4f)
        )
        Button(
            onClick = {
//                    onDelete(categoryData)
            },
            modifier = modifier,
            enabled = true
        ) {
            Text("Del")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreview() {
    val sampleCategory = CategoryData(1, "Sample Category", 1)
    ShopAppTheme {
        Category(category = sampleCategory)
    }
}