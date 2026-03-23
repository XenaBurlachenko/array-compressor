package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCompressorTest {
    
    // Вспомогательный метод для сравнения массивов
    private void assertArraysEqual(int[] expected, int[] actual) {
        assertArrayEquals(expected, actual, 
            String.format("Expected: %s, but got: %s", 
                Arrays.toString(expected), Arrays.toString(actual)));
    }
    
    @Test
    @DisplayName("Базовый тест из примера 1")
    void testBasicExample1() {
        int[] input = {1, 1, 2, 2, 3};
        int[] expected = {1, 2, 3};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    @Test
    @DisplayName("Базовый тест из примера 2")
    void testBasicExample2() {
        int[] input = {0, 0, 1, 1, 0};
        int[] expected = {0, 1, 0};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    @Test
    @DisplayName("Пустой массив")
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    @Test
    @DisplayName("Null массив")
    void testNullArray() {
        int[] expected = {};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(null));
    }
    
    @Test
    @DisplayName("Массив с одним элементом")
    void testSingleElement() {
        int[] input = {42};
        int[] expected = {42};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    @Test
    @DisplayName("Все элементы одинаковые")
    void testAllSameElements() {
        int[] input = {5, 5, 5, 5, 5};
        int[] expected = {5};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    @Test
    @DisplayName("Нет дубликатов")
    void testNoDuplicates() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    @Test
    @DisplayName("Отрицательные числа")
    void testNegativeNumbers() {
        int[] input = {-1, -1, -2, -2, -3, -1};
        int[] expected = {-1, -2, -3, -1};
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    @ParameterizedTest
    @DisplayName("Параметризованные тесты")
    @MethodSource("provideTestCases")
    void testWithParameters(int[] input, int[] expected) {
        assertArraysEqual(expected, ArrayCompressor.compressNumbers(input));
    }
    
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 2, 2, 3}, new int[]{1, 2, 3}),
            Arguments.of(new int[]{0, 0, 1, 1, 0}, new int[]{0, 1, 0}),
            Arguments.of(new int[]{1, 1, 1, 1, 1}, new int[]{1}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
            Arguments.of(new int[]{-5, -5, 0, 0, 5, 5}, new int[]{-5, 0, 5})
        );
    }
    
    @Test
    @DisplayName("Тест альтернативной реализации")
    void testAlternativeImplementation() {
        int[] input = {1, 1, 2, 2, 3, 3, 3, 4};
        int[] expected = {1, 2, 3, 4};
        
        assertArraysEqual(expected, ArrayCompressor.compressNumbersAlternative(input));
    }
}
