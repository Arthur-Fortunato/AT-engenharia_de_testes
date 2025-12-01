package br.com.infnet.ex02;

import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
