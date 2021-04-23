package homework.lesson1;

import homework.lesson1.Cat;

public class Main {
    /*
    Задание 1.1
        Приведите пример алгоритмов и структур данных из жизни:
        * Алгоритмы в жизни: Любая инструкция
        * Структуры данных: геном, энциклопедия, словарь
    Задание 1.2
        Приведите пример алгоритмов и структур данных в программировании.
        * Алгоритмы: поиск максимального числа в массиве, поиск мнимального числа, сортировка.
        * Структуры данных: int, float, String, Object
    * */

    /*
    * Задание 1.3
    Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
    * Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
        Выведите написанные данные.
Задание 1.4
Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен имитировать простейший
* поиск перебором.
Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().
* */
    public static void main(String[] args) {
        task13();
        task14();
    }

    private static Cat task13() {
        String catName = "Барсук";
        int age = 5;
        Cat cat = new Cat(catName, age);
        cat.printData();
        return cat;
    }

    private static void task14() {
        String catName = "Барсук";
        int age = 5;
        Cat cat = new Cat(catName, age);
        Cat cat1 = task13();
        long startTime = System.nanoTime();
        System.out.println("cat==cat1? " + (cat == cat1));
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения сравнения:" + endTime);
    }
}
