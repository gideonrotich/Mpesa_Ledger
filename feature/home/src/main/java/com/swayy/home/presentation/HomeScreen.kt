package com.swayy.home.presentation

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.transition.TransitionManager

@Composable
fun HomeScreen(
    mpesaViewModel: MainViewModel = hiltViewModel()
) {
    mpesaViewModel.getMessages()

    val state = mpesaViewModel.groupedMessages.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            state?.forEach {
                Text(text = it.accountNumber.toString(),color = Color.Black)
                Text(text = it.code)
            }

            LazyColumn(){
                if (state != null){
                    items(state.take(4)){
                        Text(text = it.accountNumber.toString())
                    }
                }
                else
                {

                }

            }


        }
    }
}
