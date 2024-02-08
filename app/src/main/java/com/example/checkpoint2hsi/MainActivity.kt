@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.checkpoint2hsi

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.checkpoint2hsi.ui.theme.Checkpoint2HSITheme
import javax.security.auth.login.LoginException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Checkpoint2HSITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        imageResource = R.drawable.ghazi_image,
                        modifier = Modifier
                            .fillMaxSize()
                        )
                }
            }
        }
    }
}

fun showToast(
   @StringRes content: Int,
   context: Context
) {
    Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
}

@Composable
fun Greeting(
    @DrawableRes imageResource: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var nipValue by remember {
        mutableStateOf("")
    }
    var passwordValue by remember {
        mutableStateOf("")
    }

    Column (
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null
        )

            Column (
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = stringResource(R.string.nip))
                TextField(
                    value = nipValue,
                    onValueChange = { nipValue = it },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = stringResource(R.string.password))
                TextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            Button(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .width(250.dp),
                onClick = {
                if (nipValue == "" && passwordValue == "") showToast(R.string.nip_dan_password_harus_diisi, context)
                else if (nipValue == "") showToast(R.string.nip_harus_diisi, context)
                else if (passwordValue == "") showToast(R.string.password_harus_diisi, context)
                else showToast(R.string.menuju_halaman_beranda, context)

            }) {
                Text(text = stringResource(R.string.login))
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = stringResource(R.string.belum_bisa_akses))

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = stringResource(R.string.hubungi_cs_ikhwan),
                color = colorResource(R.color.primary),
                modifier = Modifier
                    .clickable { showToast(R.string.menghubungi_cs_ikhwan, context) }
                )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = stringResource(R.string.hubungi_cs_akhwat),
                color = colorResource(R.color.primary),
                modifier = Modifier
                    .clickable { showToast(R.string.menghubungi_cs_akhwat, context) }
                )





            OutlinedButton( modifier = Modifier.
                padding(top = 40.dp),
                onClick = {
                showToast(R.string.menuju_halaman_faq, context)
            }) {
                Text(text = stringResource(R.string.lihat_faq))
            }


    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Checkpoint2HSITheme {
        Greeting(
            imageResource = R.drawable.ghazi_image,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}