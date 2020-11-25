package com.famcs;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static javafx.application.Platform.exit;

public class Main {

    private static final int SORT_IN_ASCENDING_ORDER = 1;
    private static final int SORT_IN_DESCENDING_ORDER = 2;
    private static final int SORT_IN_ASCENDING_ORDER_BY_AMOUNT_DIGITS = 3;
    private static final int SORT_IN_DESCENDING_ORDER_OF_AMOUNT_DIGITS = 4;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter size of the array");
            int arrSize = scan.nextInt();
            List<Integer> arr = new Vector<>(0);

            Random randGen = new Random();

            for (int i = 0; i < arrSize; i++) {
                arr.add(randGen.nextInt(10000));
            }

            System.out.println("Array size = " + arrSize);
            System.out.println("Array : \n" + arr);

            menu();

            int choice = scan.nextInt();
            Comparator<Integer> comp;
            switch (choice) {
                case SORT_IN_ASCENDING_ORDER:
                    comp = (x, y) -> x - y;
                    break;
                case SORT_IN_DESCENDING_ORDER:
                    comp = (x, y) -> y - x;
                    break;
                case SORT_IN_ASCENDING_ORDER_BY_AMOUNT_DIGITS:
                    comp = (x, y) -> numberOfDigits(x) - numberOfDigits(y);
                    break;
                case SORT_IN_DESCENDING_ORDER_OF_AMOUNT_DIGITS:
                    comp = (x, y) -> numberOfDigits(y) - numberOfDigits(x);
                    break;
                default:
                    throw new IOException("ERROR: wrong command");
            }

            Sort runnableSort = new Sort(arr, comp);
            Thread sortThread = new Thread(runnableSort);
            sortThread.start();
            sortThread.join();
            List<Integer> sortedArr = runnableSort.getArr();
            System.out.println("Sorted array:\n" + sortedArr);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }

    public static void menu() {
        System.out.println(
                "Enter 1 to SORT IN ASCENDING ORDER\n" +
                        "Enter 2 to SORT IN DESCENDING ORDER;\n" +
                        "Enter 3 to SORT IN ASCENDING_ORDER BY AMOUNT DIGITS ;\n" +
                        "Enter 4 to SORT IN DESCENDING ORDER OF AMOUNT DIGITS;");
    }

    public static int numberOfDigits(Integer num) {
        int temp = num;
        int res = 0;
        while(temp != 0){
            temp /= 10;
            res++;
        }
        return res;
    }
}
