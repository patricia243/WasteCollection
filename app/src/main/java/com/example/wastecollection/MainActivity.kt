package com.example.wastecollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wastecollection.ui.theme.WasteCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WasteCollectionTheme {
              
                }
            WasteCollectionApp()
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WasteCollectionApp() {
    val companies = listOf(
        Company(
            name = "Entreprise A",
            type = "Collecte des déchets ménagers",
            description = "Cette entreprise se spécialise dans la collecte régulière des déchets ménagers auprès des particuliers et des petits commerces. Ses équipes formées assurent une collecte fiable et le respect des normes environnementales."
        ),
        Company(
            name = "Entreprise B",
            type = "Collecte et recyclage des déchets organiques",
            description = "Spécialisée dans la collecte et le recyclage des déchets organiques tels que les restes alimentaires et les déchets de jardin, cette entreprise propose des solutions de compostage pour réduire l'impact environnemental."
        ),
        Company(
            name = "Entreprise C",
            type = "Collecte et élimination des déchets dangereux",
            description = "Cette entreprise gère la collecte et l'élimination sécurisée des déchets dangereux comme les produits chimiques, les piles et les médicaments. Elle garantit la conformité aux réglementations en vigueur."
        ),
        Company(
            name = "Entreprise D",
            type = "Collecte et recyclage des déchets de construction",
            description = "Spécialisée dans la collecte et le recyclage des déchets de construction et de démolition, cette entreprise propose des solutions de valorisation des matériaux pour réduire les déchets."
        ),
        Company(
            name = "Entreprise E",
            type = "Collecte et élimination des déchets industriels",
            description = "Cette entreprise offre des services de collecte et d'élimination sûre des déchets industriels dans le respect des normes environnementales. Elle travaille en étroite collaboration avec les entreprises pour personnaliser ses services."
        )
    )

    var selectedCompany by remember { mutableStateOf<Company?>(null) }

    Scaffold1(
        topBar = { TopAppBar(title = { Text("Service de collecte de déchets") }) }
    )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(companies) { company ->
                    CompanyCard(company = company) {
                        selectedCompany = company
                    }
                }
            }

            if (selectedCompany != null) {
                OrderForm(selectedCompany!!)
            }
        }
    }

fun Scaffold1(topBar: @Composable () -> Unit) {

}

@Composable
fun CompanyCard(company: Company, onSelect: () -> Unit) {
    Card(modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() },
       ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(company.name, style = MaterialTheme.typography.headlineLarge)
            Text(company.type, style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(company.description)
        }
    }
}



@Composable
fun OrderForm(company: Company) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Commandez auprès de ${company.name}", style = MaterialTheme.typography.headlineLarge)
            // Ajoutez ici les champs de formulaire pour la commande
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WasteCollectionAppPreview() {
    WasteCollectionApp()
    }


