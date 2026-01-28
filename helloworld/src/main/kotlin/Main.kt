import com.diacht.ktest.compose.startTestUi
//import com.diacht.ktest.library.BuildConfig
//import me.tetiana.helloworld.BuildConfig
import org.example.helloworld.BuildConfig
import kotlin.math.*

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import kotlinx.coroutines.*

fun seed(): String = "Kokyutosu"
fun labNumber() : Int = BuildConfig.LAB_NUMBER

suspend fun getNumberFromServer(message: String): Int {
    return withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=$message")
        val connection = url.openConnection()
        connection.connect()
        val input = connection.getInputStream()
        val buffer = ByteArray(128)
        val bytesRead = input.read(buffer)
        input.close()
        String(buffer, 0, bytesRead).toInt()
    }
}

suspend fun serverDataCalculate(strList: List<String>):Double = coroutineScope {
        val deferredResults = strList.map { str -> async { getNumberFromServer(str) } }
        val results = deferredResults.awaitAll()
        val sumModules = results.sumOf { it.toDouble().absoluteValue }
        sumModules.pow(1.0/3.0)

}

fun main() = runBlocking {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    val data = listOf("x0", "x1", "x2", "x3", "x4")
    val result = serverDataCalculate(data)
    println(result)
    startTestUi(seed(), labNumber())
}