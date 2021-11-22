package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente xuxa;
    Cliente silvio;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "12345678900", "1234567");
        silvio = new Cliente("Silvio","11123456789", "21212121");

        contaXuxa = new Conta("2002", "200275", 2500.00, xuxa);
        contaSilvio = new Conta("2003", "200375", 3500.00, silvio);

    }
    @Test
    @DisplayName("Realizar transferencia")
    void realizarTransferencia() {
        contaXuxa.realizarTransferencia(1000.00, contaSilvio);
        assertEquals(4500.00,contaSilvio.getSaldo(), "Transferencia realizada! O valor é de 4500 reais");
    }
    @Test
    @DisplayName("Realizar transação válida")
    void realizarTransacaoValida() {

        boolean resultado = contaXuxa.realizarTransferencia(1000.00, contaSilvio);
        assertTrue(resultado, "Transação válida");
    }

    @Test
    @DisplayName("Realizar transação inválida")
    void realizarTransacaoInvalida() {

        boolean resultado = contaXuxa.realizarTransferencia(2600, contaSilvio);
        assertFalse(resultado);
    }
    @Test
    void realizarSaqueValido() {
       contaXuxa.realizarSaques(2500.00);
       assertEquals(0.0, contaXuxa.getSaldo());
    }
    @Test
    void realizarSaqueInvalido() {
        contaXuxa.realizarSaques(2501.00);
        assertEquals(2500.00, contaXuxa.getSaldo(), "Saque inválido!");
    }
    @Test
    void realizarDeposito() {
        contaXuxa.realizarDeposito(1000.00);
        assertEquals(3500.00, contaXuxa.getSaldo());
    }
    @Test
    @DisplayName("Validar proprietário")
    void validaProprietario(){
        assertEquals(xuxa, contaXuxa.getProprietario());
    }
    @Test
    @DisplayName("Validar numero da conta ")
    void validarNumeroDaConta(){
        assertEquals("200275", contaXuxa.getNumeroConta());
    }
    @Test
    @DisplayName("Validar numero da Agencia")
    void validarNumeroDaAgencia(){
        assertEquals("2002", contaXuxa.getAgencia());
    }
    @Test
    void getNome() {
        assertEquals("Xuxa", xuxa.getNome());
    }

    @Test
    void getCpf() {
        assertEquals("12345678900", xuxa.getCpf());
    }

    @Test
    void getRg() {
        assertEquals("1234567", xuxa.getRg());
    }
}