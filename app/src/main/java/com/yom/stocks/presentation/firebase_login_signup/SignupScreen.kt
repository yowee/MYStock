package com.yom.stocks.presentation.firebase_login_signup


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.yom.stocks.presentation.navigation.AppRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }
    val errorState = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = confirmPasswordState.value,
            onValueChange = { confirmPasswordState.value = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorState.value != null) {
            Text(
                text = errorState.value!!,
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {
                val email = emailState.value
                val password = passwordState.value
                val confirmPassword = confirmPasswordState.value

                if (password == confirmPassword) {
                    signUpWithEmailAndPassword(email, password, errorState, navController)
                } else {
                    // Passwords don't match, show an error message
                    errorState.value = "Passwords do not match"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {
                navController.navigate(AppRoutes.SignIn)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Already have an account? Sign In")
        }
    }
}

private fun signUpWithEmailAndPassword(
    email: String,
    password: String,
    errorState: MutableState<String?>,
    navController: NavController
) {
    val auth = FirebaseAuth.getInstance()

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                navController.navigate(AppRoutes.SignIn)
            } else {
                val exception = task.exception
                errorState.value = "Sign-up failed: ${exception?.message}"
            }
        }
}
