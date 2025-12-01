package br.com.infnet.ex01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculoIMCTest {
    @Test
    void deveTestarLimiteParaMagrezaGrave() {
        assertEquals("Magreza grave", CalculoIMC.classificarIMC(15.99));
    }

    @Test
    void deveTestarLimiteInferiorESuperiorMagrezaModerada() {
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.0));
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.99));
    }

    @Test
    void deveTestarLimiteInferiorESuperiorParaMagrezaLeve() {
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(17.0));
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(18.49));
    }

    @Test
    void deveTestarLimiteInferiorESuperiorParaSaudavel() {
        assertEquals("Saudável", CalculoIMC.classificarIMC(18.5));
        assertEquals("Saudável", CalculoIMC.classificarIMC(24.99));
    }

    @Test
    void deveTestarLimiteInferiorESuperiorParaSobrepeso() {
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(25.0));
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(29.99));
    }

    @Test
    void deveTestarLimiteInferiorESuperiorParaObesidadeI() {
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(30.0));
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(34.99));
    }

    @Test
    void deveTestarLimiteInferiorESuperiorParaObesidadeII() {
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(35.0));
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(39.99));
    }

    @Test
    void deveTestarLimiteParaObesidadeIII() {
        assertEquals("Obesidade Grau III", CalculoIMC.classificarIMC(40.0));
    }

    @Test
    @DisplayName("Deve disparar erro com peso igual a zero")
    void testandoCalculoPesoComPesoIgualAZero(){
        assertThrows(ArithmeticException.class, () -> CalculoIMC.calcularPeso(0, 1.80));
    }

    @Test
    @DisplayName("Deve disparar erro com peso negativo")
    void testandoCalculoPesoComPesoNegativo(){
        assertThrows(IllegalArgumentException.class, () -> CalculoIMC.calcularPeso(-1, 1.80));
    }

    @Test
    @DisplayName("Deve disparar erro com altura igual a zero")
    void testandoCalculoPesoComAlturaIgualAZero(){
        assertThrows(ArithmeticException.class, () -> CalculoIMC.calcularPeso(90, 0));
    }

    @Test
    @DisplayName("Deve disparar erro com altura negativa")
    void testandoCalculoPesoComAlturaNegativo(){
        assertThrows(IllegalArgumentException.class, () -> CalculoIMC.calcularPeso(90, -1));
    }

    @Test
    void testandoCalculoPesoComValoresValidos(){
        assertEquals(27.78, CalculoIMC.calcularPeso(90, 1.80), 0.01);
    }
}
