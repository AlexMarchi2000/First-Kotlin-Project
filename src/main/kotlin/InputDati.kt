fun leggiDouble(message: String): Double {
    print(message)
    try {
        val double = readLine()
        return double!!.toDouble()
    }catch (e: NumberFormatException) {throw IllegalArgumentException("Errore di inserimento")}
}

fun leggiIntero(message: String = "Inserisci un intero: "): Int {
    print(message)
    try {
        val intero = readLine()
        return intero!!.toInt()
    }catch (e: NumberFormatException) {throw IllegalArgumentException("Errore di inserimento")}
}