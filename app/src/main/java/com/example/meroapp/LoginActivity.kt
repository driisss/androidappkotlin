package com.example.meroapp



import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meroapp.ui.theme.MeroAppTheme

import kotlinx.coroutines.launch

class LoginActivities : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignUpBody()
        }

    }
}



@Composable
fun SignUpBody(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var rememberMe by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val activity = context as Activity


    val coroutineScope = rememberCoroutineScope()
    val snackbarHostScope = remember { SnackbarHostState() }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostScope) }
    ){innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { showDialog = true }) {
                Text("Show AlertDialog")
            }
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {
                        showDialog = false
                    }, // dismiss when clicked outside
                    confirmButton = {
                        Button(onClick = {
                            // Confirm action
                            showDialog = false
                        }) {
                            Text("OK")
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            // Cancel action
                            showDialog = false
                        }) {
                            Text("Cancel")
                        }
                    },
                    title = { Text(text = "Alert Title") },
                    text = { Text("This is an alert dialog message.") }
                )
            }

            Image(
                painter = painterResource(R.drawable.login), contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .width(190.dp)

            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(12.dp),
                prefix = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                // to include a default email values

                placeholder = {
                    Text("Email")
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )


            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(12.dp),
                prefix = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },// to include a default email values
                placeholder = {
                    Text("Password")
                },
                suffix = {
                    Icon(
                        painter = painterResource(
                            if (passwordVisibility) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                passwordVisibility = !passwordVisibility
                            }
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = {
                            rememberMe = it
                        },

                        )

                    Text("Remember me")
                }

                Text("Forget Password", Modifier.padding(10.dp))
            }
            Button(
                onClick = {
                    if (email == "ram@gmail.com"
                        && password == "password"
                    ) {
                        Toast.makeText(
                            context, "Login Success",
                            Toast.LENGTH_SHORT
                        )
                            .show()

                    }
                    else {
                        coroutineScope.launch {
                            snackbarHostScope.showSnackbar("Invalid Login",
                            )
                        }
                    }

                },
                modifier = Modifier.width(200.dp)
            ) {
                Text("Login")
            }
            Text("Dont have an account? Sign Up",
                Modifier
                    .padding(10.dp)
                    .clickable {
                        val intent = Intent(context, TaskActivity::class.java)
                        context.startActivity(intent)


                    }


            )


        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    SignUpBody()
}