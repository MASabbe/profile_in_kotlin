package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profile.data.Datasource
import com.example.profile.ui.theme.ProfileTheme
import com.example.profile.model.Profile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProfileApp();
                }
            }
        }
    }
}

@Composable
fun ProfileApp() {
    ProfileList(
        profiles = Datasource().loadAffirmations(),
    )
}
@Composable
fun ProfileList(profiles: List<Profile>, modifier: Modifier = Modifier) {
    Column {
        LazyRow(modifier = modifier) {
            items(profiles) { profile ->
                ProfileCard(profile = profile)
            }
        }
        Column {
            Card(
                modifier = Modifier.padding(16.dp).width(360.dp).align(Alignment.CenterHorizontally),
                elevation = CardDefaults.cardElevation(8.dp)
            ){
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(text = "Previous")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}
@Composable
fun ProfileCard(profile: Profile, modifier: Modifier = Modifier) {
    Column {
        Card(modifier = modifier.padding(16.dp)) {
            Column{
                Image(
                    painter = painterResource(profile.imageResourceId),
                    contentDescription = stringResource(profile.stringResourceNameId),
                    modifier = Modifier.fillMaxWidth().width(360.dp).height(500.dp).padding(16.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Card(modifier = modifier.padding(16.dp).width(360.dp).align(Alignment.CenterHorizontally)) {
            Column {
                Text(
                    text = LocalContext.current.getString(profile.stringResourceNIMId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = LocalContext.current.getString(profile.stringResourceNameId),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = LocalContext.current.getString(profile.stringResourceAddressId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }

    }

}
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileCard(Profile(R.string.profile11, R.string.profile12, R.string.profile13, R.drawable.profile));
}