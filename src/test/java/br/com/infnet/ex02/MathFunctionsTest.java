package br.com.infnet.ex02;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathFunctionsTest {
    @Property
    void DeveTestarFuncaoMultiplyByTwoSemprePar(@ForAll int numero){
        int resultado = MathFunctions.MultiplyByTwo(numero);
        assertEquals(0, resultado % 2);
    }
}
