import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class UtenteTest {

    @Test
    fun preleva() {
        val utente = Utente("username", "")
        utente.deposita(10.0)
        utente.preleva(5.0)
        assertEquals(5.0, utente.getConto())
    }

    @Test
    fun prelevaSottoZero() {
        val utente = Utente("username", "")
        assertFailsWith<IllegalArgumentException> {
            utente.preleva(1.0)
        }
    }

    @Test
    fun deposita() {
        val utente = Utente("username", "")
        utente.deposita(10.0)
        assertEquals(10.0, utente.getConto())
    }

    @Test
    fun testEquals() {
        val utente = Utente("username", "")
        val utenteConStessoNome = Utente("username", "passwordDiversa")
        assertTrue(utente.stessoUsername(utenteConStessoNome))
    }

    @Test
    fun testNotEquals() {
        val utente = Utente("username", "")
        val utenteConNomeDiverso = Utente("usernameDiverso", "passwordDiversa")
        assertFalse(utente == utenteConNomeDiverso)
    }

    @Test
    fun getUsername() {
        val utente = Utente("username", "")
        assertEquals("username", utente.username)
    }
}