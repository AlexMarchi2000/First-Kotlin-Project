class ContoCorrente {
    var conto: Double = 0.0
        private set

    fun preleva(prelievo: Double) {
        if (notEnoughMoney(prelievo))
            throw IllegalArgumentException("Non puoi prelevare più di quanto hai")
        conto -= prelievo
    }

    fun notEnoughMoney(prelievo: Double): Boolean {
        return conto - prelievo < 0
    }

    fun deposita(deposito: Double) {
        conto += deposito
    }
}