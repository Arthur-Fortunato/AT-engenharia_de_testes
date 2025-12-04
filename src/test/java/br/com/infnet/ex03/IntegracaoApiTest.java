package br.com.infnet.ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegracaoApiTest extends IntegracaoApi {
    // TESTES DE CEP
    @Test
    void deveAceitarCepValido(){
        String resposta = get("https://viacep.com.br/ws/20541038/json/");
        assertTrue(resposta.contains("Vila Isabel"));
        assertTrue(resposta.contains("Rio de Janeiro"));
    }

    @Test
    void naoDeveAceitarCepComLetras() {
        String resposta = get("https://viacep.com.br/ws/1234567A/json/");
        assertTrue(resposta.contains("Bad Request"));
    }

    @Test
    void naoDeveAceitarCepComMenosDigitos() {
        String resposta = get("https://viacep.com.br/ws/1234567/json/");
        assertTrue(resposta.contains("Bad Request"));
    }

    @Test
    void naoDeveAceitarCepComDigitoAMais() {
        String resposta = get("https://viacep.com.br/ws/123456789/json/");
        assertTrue(resposta.contains("Bad Request"));
    }

    @Test
    void naoDeveAceitarCepVazio() {
        String resposta = get("https://viacep.com.br/ws//json/");
        assertTrue(resposta.contains("Bad Request"));
    }

    // TESTES DE ENDEREÇO
    @Test
    void deveRetornarRespostaParaConsultaComEnderecoValido() {
        String resposta = get("https://viacep.com.br/ws/SP/Sao%20Paulo/Avenida%20Paulista/json/");
        assertTrue(resposta.contains("São Paulo"));
        assertTrue(resposta.contains("SP"));
    }

    @Test
    void deveRetornarListaVaziaParaLogradouroInexistente() {
        String resposta = get("https://viacep.com.br/ws/SP/Sao%20Paulo/lugar%20Inexistente/json/");
        assertEquals("[]", resposta);
    }

    @Test
    void deveRetornarRespostaParaLogradouroValidoComAcento() {
        String resposta = get("https://viacep.com.br/ws/RJ/Rio%20de%20Janeiro/Avenida%20Atlântica/json/");
        assertTrue(resposta.contains("RJ"));
        assertTrue(resposta.contains("Rio de Janeiro"));
        assertTrue(resposta.contains("Avenida Atlântica"));
    }

    @Test
    void deveRetornarListaVaziaParaUFInexistente() {
        String resposta = get("https://viacep.com.br/ws/ZZ/Rio%20de%20Janeiro/Avenida%20Atlantica/json/");
        assertEquals("[]", resposta);
    }

    @Test
    void deveRetornarListaVaziaParaCidadeInexistente() {
        String resposta = get("https://viacep.com.br/ws/RJ/Aleatorio/Avenida%20Atlântica/json/");
        assertEquals("[]", resposta);
    }
}
