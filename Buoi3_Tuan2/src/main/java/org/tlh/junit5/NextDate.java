package org.tlh.junit5;

import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day:");
        int day = scanner.nextInt();

        System.out.print("Enter month:");
        int month = scanner.nextInt();

        System.out.print("Enter year:");
        int year = scanner.nextInt();

        String nextDate = getNextDate(day, month, year);
        System.out.print("Next date is: " + nextDate);
    }

    public static String getNextDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            return "Invalid date";
        }

        day++;
        if (day > numberOfDaysInMonth(month, year)) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return day + "/" + month + "/" + year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1812 || year > 2012 || month < 1 || month > 12 || day < 1 || day > numberOfDaysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    public static int numberOfDaysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
