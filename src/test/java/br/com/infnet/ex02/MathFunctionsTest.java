package br.com.infnet.ex02;

import net.jqwik.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MathFunctionsTest {
    @Property
    void DeveTestarFuncaoMultiplyByTwoSemprePar(@ForAll int numero){
        int resultado = MathFunctions.MultiplyByTwo(numero);
        assertEquals(0, resultado % 2);
    }

    @Property
    void deveValidarQueTodosElementosSaoMultiplosDoNumeroOriginal(@ForAll("numerosNaoNegativosENaoNulos") int numero, @ForAll("numerosParaLimite") int limite){
        int[] numeros = MathFunctions.GenerateMultiplicationTable(numero, limite);
        for (int valor : numeros) {
            assertEquals(0, valor % numero);
        }
    }
    @Provide
    Arbitrary<Integer> numerosNaoNegativosENaoNulos(){
        return Arbitraries.integers().between(1, 1_000_000);
    }
    @Provide
    Arbitrary<Integer> numerosParaLimite() {
        return Arbitraries.integers().between(1, 100);
    }

    @Property
    void deveValidarQueNumeroEPrimo(@ForAll("numerosPrimos") int numeroPrimo) {
        assertTrue(MathFunctions.IsPrime(numeroPrimo));
        for (int i = 2; i <= Math.sqrt(numeroPrimo); i++) {
            assertNotEquals(0, numeroPrimo % i, "Divisor inesperado: " + i + " para o número " + numeroPrimo);
        }
    }

    @Provide
    Arbitrary<Integer> numerosPrimos() {
        return Arbitraries.integers()
                .between(2, 1000)
                .filter(MathFunctions::IsPrime);
    }

    @Property
    void deveGarantirQueMediaSempreEntreMinEMax(@ForAll("inteiros") int[] numeros) {
        double media = MathFunctions.CalculateAverage(numeros);
        int min = Arrays.stream(numeros).min().orElseThrow();
        int max = Arrays.stream(numeros).max().orElseThrow();

        assertTrue(media >= min && media <= max,"A média " + media + "está fora dos parâmetros");
    }

    @Provide
    Arbitrary<int[]> inteiros() {
        return Arbitraries.integers()
                .between(1, 1_000_000)
                .array(int[].class)
                .ofMinSize(1)
                .ofMaxSize(100);
    }


}
