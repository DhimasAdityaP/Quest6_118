import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MahasiswaFormView(
    onSubmitButtonClicked :(MutableList<String>)->Unit,
    onBackButtonClicked:()->Unit
) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(nim, nama, email)}