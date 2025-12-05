package br.com.infnet.ex05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GCDTest {

    // -----------------------------------------
    // TESTES PARA gcd(int, int)
    // -----------------------------------------

    @Test
    void deveCalcularGcdDeNumerosPositivos() {
        assertEquals(5, GCD.gcd(50, 5));
    }

    @Test
    void deveLancarExcecaoQuandoReceberNumeroNegativo() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(-50, 5));
        assertThrows(ArithmeticException.class, () -> GCD.gcd(50, -5));
    }

    @Test
    void deveRetornarADiferencaQuandoUmNumeroForZero() {
        assertEquals(10, GCD.gcd(10, 0));
        assertEquals(10, GCD.gcd(0, 10));
    }

    @Test
    void deveRetornarGcdQuandoNumerosSaoIguais() {
        assertEquals(10, GCD.gcd(10, 10));
    }

    @Test
    void deveExecutarOLoopAteORestoZero() {
        assertEquals(10, GCD.gcd(10, 100));
    }

    @Test
    void deveCalcularGcdDeArrayDeNumeros() {
        assertEquals(10, GCD.gcd(20, 30, 40, 50));
    }

    @Test
    void deveRetornarZeroParaArrayVazio() {
        assertEquals(0, GCD.gcd());
    }

    @Test
    void deveCalcularGcdQuandoVariosNumerosIncluemZero() {
        assertEquals(5, GCD.gcd(0, 5, 10, 15));
    }

    @Test
    void deveLancarExcecaoSeAlgumNumeroNegativoNoArray() {
        assertThrows(ArithmeticException.class, () -> GCD.gcd(10, -20, 5));
    }
}
