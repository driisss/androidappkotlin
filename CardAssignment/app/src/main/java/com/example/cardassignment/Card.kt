package com.example.cardassignment



import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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


import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.cardassignment.ui.theme.PurpleGrey40
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class cardassignment : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                ProfileBody(innerPadding)
            }
        }
    }
}
@Composable
fun ProfileBody(innerPadding : PaddingValues){
    Column(
        modifier = Modifier

            .padding(innerPadding)
            .fillMaxSize()
            .background(color = colorResource(id = R.color.teal_custom))

    ){
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Right
        ) {


            Image(
                painter = painterResource(R.drawable.dristi)
                ,
                contentDescription =null, modifier = Modifier.height(60.dp).width(60.dp)
                    .clip(shape = RoundedCornerShape(30.dp)),
            )

        }


        Column (modifier = Modifier.padding(horizontal=15.dp,vertical=30.dp)){
            Text(
                text = "Card",
                style = TextStyle(
                    fontSize = 50.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                )

            )
            Text(
                text = "Simple and easy to use app",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                )

            )

//            }




        }
        //spacer(Modifier
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = {
                //to do button click
            }, modifier=Modifier
                .width(200.dp)
                .padding(8.dp)
                .height(150.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)


            ) {
                Column(
                    horizontalAlignment=Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){Image(
                    painter= painterResource(R.drawable.textt),
                    contentDescription =null, modifier = Modifier.height(80.dp).width(60.dp)
                )
                    Text(text="Text",color=Color.Black)


                }


            }
            Button(onClick = {
                //to do button click
            }, modifier=Modifier
                .width(200.dp)
                .padding(8.dp)
                .height(150.dp), shape = RoundedCornerShape(10.dp),
                colors=ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment=Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.add),
                        contentDescription =null, modifier = Modifier.height(80.dp).width(60.dp)
                    )
                    Text(text="Address", color =Color.Black)

                }


            }


        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = {
                //to do button click
            }, modifier=Modifier
                .width(200.dp)
                .padding(8.dp)
                .height(150.dp), shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment=Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.charr),
                        contentDescription = null,Modifier.height(80.dp).width(60.dp))
                    Text(text="Character", color = Color.Black)
                }


            }
            Button(onClick = {
                //to do button click
            }, modifier=Modifier
                .width(200.dp)
                .padding(8.dp)
                .height(150.dp), shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment=Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.bankcard),
                        contentDescription = null,Modifier.height(80.dp).width(60.dp)
                    )
                    Text(text="Bank Card", color = Color.Black)
                }
            }


        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = {
                //to do button click
            }, modifier=Modifier
                .width(200.dp)
                .padding(8.dp)
                .height(150.dp), shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment=Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){ Image(
                    painter = painterResource(R.drawable.passs),
                    contentDescription = null,Modifier.height(80.dp).width(60.dp)
                )
                    Text(text="Password", color = Color.Black)}


            }
            Button(onClick = {
                //to do button click
            }, modifier=Modifier
                .width(200.dp)
                .padding(8.dp)
                .height(150.dp), shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment=Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.lohi),
                        contentDescription = null,Modifier.height(80.dp).width(60.dp))
                    Text(text="Logistics", color = Color.Black)
                }

            }

        }

        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = {
                //to do button click
            }, modifier=Modifier
                .padding(8.dp)
                .height(80.dp).width(900.dp)

                , shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {

                Image(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = null, Modifier.height(80.dp).width(60.dp)
                )
                Text(text = "Settings", color = Color.Black)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    ProfileBody(innerPadding = PaddingValues(0.dp))
}