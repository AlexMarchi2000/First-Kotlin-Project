import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test
import kotlin.test.assertFailsWith

internal class ContoCorrenteTest {

    @Test
    fun creaConto() {
        val contoCorrente = ContoCorrente()
        assertEquals(0.0, contoCorrente.conto)
    }

    @Test
    fun prelievoNormale() {
        val contoCorrente = ContoCorrente()
        contoCorrente.deposita(10.0)
        contoCorrente.preleva(5.0)
        assertEquals(5.0, contoCorrente.conto)
    }

    @Test
    fun prelievoSottoZero() {
        val contoCorrente = ContoCorrente()
        assertFailsWith<IllegalArgumentException> {
            contoCorrente.preleva(10.0)
        }
    }

    @Test
    fun notEnoughMoney() {
        val contoCorrente = ContoCorrente()
        assertTrue(contoCorrente.notEnoughMoney(0.1))
        assertFalse(contoCorrente.notEnoughMoney(0.0))
    }



}