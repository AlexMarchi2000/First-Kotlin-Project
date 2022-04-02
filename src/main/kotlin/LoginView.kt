class LoginView {
    private val utenteController = UtenteController()

    fun execute(): Utente {
        while (true) {
            println("\n" +
                    "1 -> Registrazione\n" +
                    "2 -> Accesso\n")
            when (leggiIntero()) {
                1 -> registrazione()
                2 -> return login()
                else -> println("Errore di inserimento")
            }
        }
    }

    private fun registrazione() {
        val username = leggi("Nuovo Username: ")
        val password = leggi("Password: ")
        try {
            utenteController.aggiungiUtente(username, password)
        }catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun login(): Utente {
        while (true) {
            try {
                val username = leggi("Username: ")
                val password = leggi("Password: ")
                return loginWithCredentials(username, password)
            }catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun loginWithCredentials(username: String, password: String): Utente {
        return utenteController.getUserByCredentials(username, password)
    }

    private fun leggi(messaggio: String = "Input: "): String {
        print(messaggio)
        return readLine()!!
    }
}