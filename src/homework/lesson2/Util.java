package homework.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Util {
    public static String getRandomString(int min, int max) {
        int result = 0;
        Random random = new Random();
        do {
            result = random.nextInt(max + 1);
        } while (result < min);
        return String.valueOf(result);
    }

    public static int getRandom(int min, int max) {
        int result = 0;
        Random random = new Random();
        do {
            result = random.nextInt(max + 1);
        } while (result < min);
        return result;
    }
    public static int[] getRandomIntArray(int min, int max, int length){
        int[] result=new int[length];
        for (int i=0;i<result.length;i++) {
            result[i]=getRandom(min,max);
        }
        return result;
    }
    public static void printIntArray(int[] array)
    {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
    public static void printMap(String[][] strings) {
        System.out.println();
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                System.out.print(strings[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
