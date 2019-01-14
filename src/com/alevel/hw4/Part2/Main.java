package com.alevel.hw4.Part2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int mass[] = {2, 42, 31, 30, 23, 29, 3, 50, 4, 6, 8, 0, 1, 5, 7, 9, 10, 24, 20};
        System.out.println("Quick Sort");
        System.out.println("in  ->" + Arrays.toString(mass));
        System.out.println("out ->" + Arrays.toString(quickSort(mass)));
    }

    public static int[] quickSort(int mass[]) {
        int[] quickSortMass = mass;
        int[] sortMass = new int[quickSortMass.length];
        sortMass[sortMass.length - 1] = quickSortMass[quickSortMass.length - 1];
        int idLeft = 0, idRight = quickSortMass.length - 1;

//        System.out.println("in  ->"+Arrays.toString(quickSortMass));
        for (int i = 0; i < quickSortMass.length; i++) {
            if (quickSortMass[i] < sortMass[idRight]) {
                sortMass[idLeft] = quickSortMass[i];
                idLeft++;
            } else if (quickSortMass[i] > sortMass[idRight]) {
                sortMass[idRight - 1] = sortMass[idRight];
                sortMass[idRight] = quickSortMass[i];
                idRight--;
            }
        }
//        System.out.println("sort->"+Arrays.toString(sortMass));
        int[] leftMass = new int[idLeft];
        int[] rightMass = new int[sortMass.length - idRight];

        for (int i = 0; i < leftMass.length; i++) {
            leftMass[i] = sortMass[i];
        }
        for (int i = 0; i < rightMass.length; i++) {
            rightMass[i] = sortMass[idRight + i];
        }
        if (sortMass.length > 2) {
            leftMass = quickSort(leftMass);
            rightMass = quickSort(rightMass);
//            System.out.println(Arrays.toString(leftMass)+"<->"+Arrays.toString(rightMass));
            for (int i = 0; i < leftMass.length; i++) {
                sortMass[i] = leftMass[i];
            }
            for (int i = 0; i < rightMass.length; i++) {
                sortMass[i + leftMass.length] = rightMass[i];
            }
//        System.out.println("sort->"+Arrays.toString(sortMass));
        }
        return sortMass;
    }
}