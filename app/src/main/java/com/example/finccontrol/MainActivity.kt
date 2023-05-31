package com.example.finccontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finccontrol.ui.theme.FincControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FincControlTheme{
                Column() {
                    Welcome()
                    Transactions()
                }
            }
        }
    }
}

@Composable
fun Transactions(){
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ){
        items(transactionsDummy.size){ index ->
            Transaction(index)
        }
    }
}

@Composable
private fun Transaction(index: Int) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Settings",
                modifier = Modifier.fillMaxHeight()
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = transactionsDummy[index],
                modifier = Modifier.padding(20.dp)
            )
        }

    }
}

@Composable
fun Welcome() {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Bem vindo cara, \n Lucas Caetano",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.weight(1f),
        )
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Clear Transictions",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

private val transactionsDummy = listOf<String>(
    "Aluguel",
    "Cursos",
    "Cartão de crédito"
)