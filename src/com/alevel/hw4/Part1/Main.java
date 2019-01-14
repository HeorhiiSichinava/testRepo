package com.alevel.hw4.Part1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int mass[] = {2, 42, 31, 30, 23, 29, 3, 50, 4, 6, 8, 0, 1, 5, 7, 9, 10, 24, 44};
        System.out.println("Merge Sort");
        System.out.println("in->" + Arrays.toString(mass));
        System.out.println("out->" + Arrays.toString(mergeSort(mass)));
    }

    public static int[] mergeSort(int mass[]) {
        int massMergeSort[] = mass;
        int leftMass[] = new int[mass.length / 2 + mass.length % 2];
        int rightMass[] = new int[mass.length / 2];

        for (int i = 0; i < leftMass.length; i++) {
            leftMass[i] = massMergeSort[i];
        }
        for (int i = 0; i < rightMass.length; i++) {
            rightMass[i] = massMergeSort[leftMass.length + i];
        }
        if ((mass.length / 2) > 0) {
            mergeSort(leftMass);
            mergeSort(rightMass);

            int idLeft = 0;
            int idRight = 0;

//            System.out.println(Arrays.toString(leftMass) + "<->" + Arrays.toString(rightMass));
            for (int i = 0; i < mass.length; i++) {
                if (idLeft < (leftMass.length) && idRight < (rightMass.length)) {
                    if (leftMass[idLeft] > rightMass[idRight]) {
                        massMergeSort[i] = rightMass[idRight];
                        idRight++;
                    } else if (leftMass[idLeft] < rightMass[idRight]) {
                        massMergeSort[i] = leftMass[idLeft];
                        idLeft++;
                    }
                } else if (idLeft == leftMass.length && idRight < rightMass.length) {
                    massMergeSort[i] = rightMass[idRight];
                    idRight++;
                } else if (idLeft < leftMass.length && idRight == rightMass.length) {
                    massMergeSort[i] = leftMass[idLeft];
                    idLeft++;
                }
//                System.out.println(Arrays.toString(massMergeSort));
            }
//        return massMergeSort;
        }
        return massMergeSort;
    }
}