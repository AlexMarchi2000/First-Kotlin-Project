class Utente(val username: String, val password: String) {
    private val contoCorrente = ContoCorrente()

    fun getConto(): Double {
        return contoCorrente.conto
    }

    fun preleva(prelievo: Double) {
        contoCorrente.preleva(prelievo)
    }

    fun deposita(deposito: Double) {
        contoCorrente.deposita(deposito)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Utente)
            username == other.username && password == other.password
        else
            false
    }

    fun stessoUsername(altroUtente: Utente): Boolean {
        return username == altroUtente.username
    }

    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + contoCorrente.hashCode()
        return result
    }

}