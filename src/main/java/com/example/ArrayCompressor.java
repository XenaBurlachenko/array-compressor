package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для удаления подряд идущих дубликатов из массива чисел
 */
public class ArrayCompressor {
    
    /**
     * Удаляет подряд идущие дубликаты из массива чисел
     * 
     * @param numbers входной массив чисел
     * @return новый массив без последовательных дубликатов
     */
    public static int[] compressNumbers(int[] numbers) {
        // Обработка null или пустого массива
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(numbers[0]);
        
        for (int i = 1; i < numbers.length; i++) {
            // Если текущий элемент не равен предыдущему, добавляем его
            if (numbers[i] != numbers[i - 1]) {
                result.add(numbers[i]);
            }
        }
        
        // Преобразуем List<Integer> в int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * Альтернативная реализация без использования коллекций
     */
    public static int[] compressNumbersAlternative(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        
        // Сначала подсчитываем количество уникальных элементов
        int uniqueCount = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) {
                uniqueCount++;
            }
        }
        
        // Создаем результирующий массив нужного размера
        int[] result = new int[uniqueCount];
        result[0] = numbers[0];
        
        int index = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) {
                result[index++] = numbers[i];
            }
        }
        
        return result;
    }
}
