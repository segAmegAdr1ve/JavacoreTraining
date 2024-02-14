package com.example.user.javacoretraining.training;

import java.util.HashMap;
import java.util.Map;

/**
 * Набор тренингов по работе с массивами в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ArraysTrainingTest.
 */
public class ArraysTraining {

    /**
     * Метод должен сортировать входящий массив
     * по возрастранию пузырьковым методом
     *
     * @param valuesArray массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] valuesArray) {
        for (int i = 0; i < valuesArray.length - 1; i++) {
            for (int j = 0; j < valuesArray.length - i - 1; j++) {
                if (valuesArray[j] > valuesArray[j + 1]) {
                    int tempItem = valuesArray[j];
                    valuesArray[j] = valuesArray[j + 1];
                    valuesArray[j + 1] = tempItem;
                }
            }
        }
        return valuesArray;
    }

    /**
     * Метод должен возвращать максимальное
     * значение из введенных. Если входящие числа
     * отсутствуют - вернуть 0
     *
     * @param values входящие числа
     * @return максимальное число или 0
     */
    public int maxValue(int... values) {
        if (values.length == 0) return 0;
        int maxValue = values[0];
        for (int value: values) {
            if (value > maxValue) maxValue = value;
        }
        return maxValue;
    }

    /**
     * Переставить элементы массива
     * в обратном порядке
     *
     * @param array массив для преобразования
     * @return входящий массив в обратном порядке
     */
    public int[] reverse(int[] array) {
        //TODO: implement it
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int tempItem = array[start];
            array[start] = array[end];
            array[end] = tempItem;
            start++;
            end--;
        }
        return array;
    }

    /**
     * Метод должен вернуть массив,
     * состоящий из чисел Фибоначчи
     *
     * @param numbersCount количество чисел Фибоначчи,
     *                     требуемое в исходящем массиве.
     *                     Если numbersCount < 1, исходный
     *                     массив должен быть пуст.
     * @return массив из чисел Фибоначчи
     */
    public int[] fibonacciNumbers(int numbersCount) {
        if (numbersCount < 1) return new int[]{};
        int[] fibonacciArray = new int[numbersCount];
        fibonacciArray[0] = 1;
        if (numbersCount > 1) {
            fibonacciArray[1] = 1;
            for (int i = 2; i < numbersCount; i++) {
                fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
            }
        }
        return fibonacciArray;
    }

    /**
     * В данном массиве найти максимальное
     * количество одинаковых элементов.
     *
     * @param array массив для выборки
     * @return количество максимально встречающихся
     * элементов
     */
    public int maxCountSymbol(int[] array) {
        if (array.length == 0) return 0;
        Map<Integer, Integer> matchingMap = new HashMap<>();
        for (int num : array) {
            if (matchingMap.containsKey(num)) {
                matchingMap.put(num, matchingMap.get(num) + 1);
            } else {
                matchingMap.put(num, 1);
            }
        }
        int maxCount = 0;
        for (int count : matchingMap.values()) {
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }
}
