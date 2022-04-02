class UtenteView(private val utente: Utente) {

    fun execute() {
        while (true) {
            println("\n" +
                    "1 -> Prelievo\n" +
                    "2 -> Deposito\n" +
                    "3 -> Visualizza conto\n" +
                    "0 -> Esci\n")
            when (leggiIntero()) {
                1 -> preleva()
                2 -> deposita()
                3 -> visualizzaConto()
                0 -> return
                else -> println("Errore di inserimento")
            }
        }
    }

    private fun preleva() {
        val prelievo = leggiDouble("Inserisci importo del prelievo: ")
        try {
            utente.preleva(prelievo)
        }catch (e: IllegalArgumentException) {
            println(e.message)
        }

    }

    private fun deposita() {
        val deposito = leggiDouble("Inserisci importo del deposito: ")
        utente.deposita(deposito)
    }

    private fun visualizzaConto() {
        println("Saldo attuale: ${utente.getConto()}")
    }
}