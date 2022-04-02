import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class UtenteControllerTest {

    @Test
    fun aggiungiUtente() {
        val utenteController = UtenteController()
        utenteController.aggiungiUtente("username", "")
        assertEquals(Utente("username", ""), utenteController.getUserByUsername("username"))
    }

    @Test
    fun aggiungiUtenteCheEsiste() {
        val utenteController = UtenteController()
        utenteController.aggiungiUtente("username", "")
        assertFailsWith<IllegalArgumentException> {
            utenteController.aggiungiUtente("username", "passwordDiversa")
        }
    }

    @Test
    fun getUserByUsernameCheNonEsiste() {
        val utenteController = UtenteController()
        assertFailsWith<IllegalArgumentException> {
            utenteController.getUserByUsername("utenteCheNonEsiste")
        }
    }

    @Test
    fun getUserByCredentials() {
        val utenteController = UtenteController()
        utenteController.aggiungiUtente("username", "password")
        assertEquals(Utente("username", "password"), utenteController.getUserByCredentials("username", "password"))
    }

    @Test
    fun getUserByCredentialsErrate() {
        val utenteController = UtenteController()
        utenteController.aggiungiUtente("username", "password")
        assertFailsWith<IllegalArgumentException> {
            utenteController.getUserByCredentials("username", "passwordDiversa")
        }
    }

}