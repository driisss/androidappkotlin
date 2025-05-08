package com.example.meroapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meroapp.ui.theme.MeroAppTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeroAppTheme {
                Scaffold { innerPadding ->
                    LoginBody(innerPadding)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBody(innerPadding: PaddingValues) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(R.drawable.login),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { input -> email = input },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            prefix = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            placeholder = {
                Text("abc@gmail.com")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Gray.copy(0.2f),
                unfocusedContainerColor = Color.Gray.copy(0.2f),
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { input -> password = input },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            prefix = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            suffix = {
                Icon(
                    painter = painterResource(
                        if (passwordVisibility) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
                    ),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        passwordVisibility = !passwordVisibility
                    }
                )
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            placeholder = {
                Text("*******")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Gray.copy(0.2f),
                unfocusedContainerColor = Color.Gray.copy(0.2f),
            )
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.padding(10.dp)
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    checkmarkColor = Color.White
                )
            )
            Text(text = "Remember me", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Forgot Password
        Text(
            text = "Forgot Password?",
            color = Color.Blue,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
                .clickable { /* Handle forgot password */ }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Login Button
        Button(
            onClick = {
                if (email == "ram@gmail.com" && password == "password") {
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    MeroAppTheme {
        LoginBody(PaddingValues(0.dp))
    }
}
