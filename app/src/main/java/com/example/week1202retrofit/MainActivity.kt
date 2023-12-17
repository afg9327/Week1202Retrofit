package com.example.week1202retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week1202retrofit.ui.theme.Week1202RetrofitTheme

class MainActivity : ComponentActivity() {
    // ViewModelProvider 사용해도 됨
    private val viewModel: ChampionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: ChampionViewModel) {
    val championList by viewModel.championList.observeAsState(emptyList())

    Week1202RetrofitTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChampionList(championList)
        }
    }
}

@Composable
fun ChampionList(list: List<Champion>) {
    Column {
        Text(list.toString())
    }
}