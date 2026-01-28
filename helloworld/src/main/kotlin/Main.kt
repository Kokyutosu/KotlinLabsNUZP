import com.diacht.ktest.compose.startTestUi
//import com.diacht.ktest.library.BuildConfig
//import me.tetiana.helloworld.BuildConfig
import org.example.helloworld.BuildConfig
import kotlin.math.*

fun seed(): String = "Kokyutosu"
fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(
    x0:Int = -95,
    x1:Int = 97,
    x2:Int = -17,
    x3:Int = 114,
    x4:Int = -77
) : Double {
    val x: Double = ln(x0.toDouble() * x1.toDouble() * x2.toDouble() * x3.toDouble() * x4.toDouble())
    //val res: Double = ln(x)
    return x

    //-95*97*(-17)*114*(-77)
}

fun dCalculate(
    x0:Double = -0.32,
    x1:Double = -27.72,
    x2:Double = -47.73,
    x3:Double = -26.25,
    x4:Double = 36.04
): Double {
    val x:Double = cbrt(x0 * x1 * x2 * x3 * x4)
    return x
}

fun strCalculate(
    x0:String = "ATGCJ",
    x1:String = "ATGCJ"
):Int {

    val half = x0.length / 2
    var result = 0

    for (i in x0.indices) {
        val ch0 = x0[i]
        if (ch0 == 'T' || ch0 == 'C') {
            if (x0[i] != x1[i]) {
                result += if (i < half) 2 else 1
            }
        }
    }

    return result
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    println(iCalculate())
    println(dCalculate())
    println(strCalculate())

    startTestUi(seed(), labNumber())
}