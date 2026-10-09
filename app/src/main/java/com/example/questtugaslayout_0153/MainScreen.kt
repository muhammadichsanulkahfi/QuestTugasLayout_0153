package com.example.questtugaslayout_0153

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// WIDGET CARD (Fungsi Terpisah dari Utama)
@Composable
fun StudentCardWidget(
    nameRes: Int,
    detailRes: Int?,
    locationRes: Int,
    backgroundColorRes: Int,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = backgroundColorRes)
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Logo Kiri
            Image(
                painter = painterResource(id = R.drawable._1942014),
                contentDescription = null,
                modifier = Modifier.size(56.dp)
            )

            // Informasi Tengah
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(id = nameRes),
                    color = colorResource(id = R.color.text_white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                if (detailRes != null) {
                    Text(
                        text = stringResource(id = detailRes),
                        color = colorResource(id = R.color.text_cyan),
                        fontSize = 14.sp
                    )
                }
                Text(
                    text = stringResource(id = locationRes),
                    color = colorResource(id = R.color.text_yellow),
                    fontSize = 14.sp
                )
            }

            // Logo Kanan
            Image(
                painter = painterResource(id = R.drawable._1942014),
                contentDescription = null,
                modifier = Modifier.size(56.dp)
            )
        }
    }
}

// FUNGSI UTAMA
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = stringResource(id = R.string.title_dept),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_black)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.subtitle_univ),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_black)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Daftar Card Menggunakan Widget Terpisah
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Card 1: Data Diri
            StudentCardWidget(
                nameRes = R.string.student1_name,
                detailRes = R.string.student1_nim,
                locationRes = R.string.student1_location,
                backgroundColorRes = R.color.card_gray
            )
            // Card 2
            StudentCardWidget(
                nameRes = R.string.student2_name,
                detailRes = R.string.student2_phone,
                locationRes = R.string.student2_location,
                backgroundColorRes = R.color.card_purple
            )
            // Card 3
            StudentCardWidget(
                nameRes = R.string.student3_name,
                detailRes = R.string.student3_phone,
                locationRes = R.string.student3_location,
                backgroundColorRes = R.color.card_blue
            )
            // Card 4
            StudentCardWidget(
                nameRes = R.string.student4_name,
                detailRes = R.string.student4_phone,
                locationRes = R.string.student4_location,
                backgroundColorRes = R.color.card_green
            )
        }

        // Footer
        Text(
            text = stringResource(id = R.string.footer_copyright),
            fontSize = 12.sp,
            color = colorResource(id = R.color.text_black),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}





@Composable
fun StudentCardWidget(
    nameRes: Int,
    detailRes: Int?,
    locationRes: Int,
    backgroundColorRes: Int
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(backgroundColorRes)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(stringResource(nameRes))

            if (detailRes != null) {
                Text(stringResource(detailRes))
            }

            Text(stringResource(locationRes))
        }
    }
}