class UtenteController {
    private val utenti = mutableMapOf<String, Utente>()

    fun aggiungiUtente(username: String, password: String) {
        if (utenti.containsKey(username))
            throw IllegalArgumentException("Utente già presente")
        utenti[username] = Utente(username, password)
    }

    fun getUserByUsername(username: String): Utente {
        return if (utenti.containsKey(username)) utenti[username]!! else throw IllegalArgumentException("Utente non presente")
    }

    fun getUserByCredentials(username: String, password: String): Utente {
        return if (utenti.values.contains(Utente(username, password)))
            utenti.values.find { utente -> utente == Utente(username, password) }!!
        else throw IllegalArgumentException("Credenziali errate")
    }
}