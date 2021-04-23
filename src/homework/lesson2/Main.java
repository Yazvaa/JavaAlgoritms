package homework.lesson2;

import homework.lesson1.Cat;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Arrays;

/*
Задание 2.1 (task21)
        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих
        примитивных или ссылочных типов данных.
        Выполните обращение к массиву и базовые операции класса Arrays.
        Оценить выполненные методы с помощью базового класса System.nanoTime().
Задание 2.2 (task22)
        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(),
        при необходимости расширьте уже существующий массив данных.
Задание 2.3 (task23)
        Создайте массив размером 400 элементов.
        Выполните сортировку с помощью метода sort().
        Оцените сортировку с помощью базового класса System.nanoTime().
Задание 2.4 (task24)
        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.3 и сортировку пузырьком.
Задание 2.5 (task25)
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
Задание 2.6 (task26)
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
 */
public class Main {
    static long timeSortBubbles = 0;
    static long timeSortArray = 0;
    static long timeSortSelect = 0;
    static long timeSortInsert = 0;

    public static void main(String[] args) {
        task21();
        task22();
        task23();
        task24();
        task25();
        task26();
    }

    static void task21() {
        System.out.println("\nЗадание 2.1");
        int[] ints = Util.getRandomIntArray(10, 100, 20);
        System.out.println(ints[2]);
        long startTime = System.nanoTime();
        int[] copyInts = Arrays.copyOf(ints, ints.length);
        Arrays.sort(ints);
        long endTime = System.nanoTime() - startTime;
        Util.printIntArray(ints);
        Util.printIntArray(copyInts);
        System.out.println("\nВремя выполнения: " + endTime / 1000000);
    }

    static void task22() {
        System.out.println("\nЗадание 2.2");
        int[] ints = Util.getRandomIntArray(0, 10, 20);
        int key = Util.getRandom(0, 10);
        System.out.println("Исходный массив:\n");
        Util.printIntArray(ints);
        System.out.println("Ключ поиска: " + key);
        long startTime = System.nanoTime();
        lineFind(ints, key);
        long endTime = System.nanoTime() - startTime;
        System.out.println("\nВремя выполнения: " + endTime / 1000000);
        Arrays.sort(ints);
        Util.printIntArray(ints);
        startTime = System.nanoTime();
        binaryFind(ints, key);
        endTime = System.nanoTime() - startTime;
        System.out.println("\nВремя выполнения: " + endTime / 1000000);
    }

    static void task23() {
        System.out.println("Задание 2.3");
        int[] ints = Util.getRandomIntArray(0, 4000, 400);
        long startTime = System.nanoTime();
        Arrays.sort(ints);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время сортировки - " + endTime);
    }

    static void task24() {
        System.out.println("Задание 2.4");
        int[] ints = Util.getRandomIntArray(0, 4000, 400);
        Util.printIntArray(ints);
        System.out.println(ints);
        long startBubblesSort = System.nanoTime();
        sortBubble(ints);
        timeSortBubbles = System.nanoTime() - startBubblesSort;
        Util.printIntArray(ints);
        ints = Util.getRandomIntArray(0, 4000, 400);
        long startArraySort = System.nanoTime();
        Arrays.sort(ints);
        timeSortArray = System.nanoTime() - startArraySort;
        System.out.println("Сортировка пузырьком - " + timeSortBubbles);
        System.out.println("сортировка Array.sort - " + timeSortArray);
    }

    static void task25() {
        int[] ints=Util.getRandomIntArray(0,4000,400);
        Util.printIntArray(ints);
        long startSelectSort=System.nanoTime();
        sortSelect(ints);
        timeSortSelect=System.nanoTime()-startSelectSort;
        Util.printIntArray(ints);
        System.out.println("Сортировка пузырьком \t\t" + timeSortBubbles);
        System.out.println("сортировка Array.sort \t\t" + timeSortArray);
        System.out.println("сортировка выбором \t\t\t" + timeSortSelect);
    }

    static void task26(){
        int[] ints=Util.getRandomIntArray(0,4000,400);
        Util.printIntArray(ints);
        long startInsertSort=System.nanoTime();
        sortInsert(ints);
        timeSortInsert=System.nanoTime()-startInsertSort;
        Util.printIntArray(ints);
        System.out.println("Сортировка пузырьком \t\t" + timeSortBubbles);
        System.out.println("сортировка Array.sort \t\t" + timeSortArray);
        System.out.println("сортировка выбором \t\t\t" + timeSortSelect);
        System.out.println("сортировка вставкой \t\t" + timeSortInsert);
    }

    static void sortInsert(int[] arr){
        int key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void sortSelect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    pos = j;
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
        }
    }

    static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    static void lineFind(int[] arr, int key) {
        System.out.println("Линейный поиск\nВхождения (индекс элемента):");
        boolean findOk = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                findOk = true;
                System.out.print("\t" + i);
            }
        }
        if (!findOk)
            System.out.println("Вхождений нет");
    }

    static void binaryFind(int arr[], int key) {
        System.out.println("Бинарный поиск\n\tВхождения:");
        boolean findOk = false;
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == key) {
                findOk = true;
                boolean isForward = true;
                int tmp = middleIndex;
                for (int i = 0; i < 2; i++) {
                    while ((middleIndex >= 0)&&(middleIndex<arr.length)&&(arr[middleIndex] == key)) {
                        System.out.print("\t" + middleIndex);
                        if (isForward)
                            middleIndex++;
                        else
                            middleIndex--;
                    }
                    isForward = false;
                    middleIndex = tmp - 1;
                    if (middleIndex < 0)
                        return;
                }
                return;
            } else if (arr[middleIndex] < key)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > key)
                lastIndex = middleIndex - 1;
        }
        System.out.println("Вхождений нет");
    }
}

