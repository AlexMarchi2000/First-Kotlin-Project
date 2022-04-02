fun main() {
    val loginView = LoginView()
    val utente = loginView.execute()

    val utenteView = UtenteView(utente)
    utenteView.execute()
}