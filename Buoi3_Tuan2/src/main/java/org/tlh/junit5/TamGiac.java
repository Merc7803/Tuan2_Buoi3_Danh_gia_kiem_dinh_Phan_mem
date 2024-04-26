package org.tlh.junit5;

import java.util.Scanner;

public class TamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so do 3 canh cua tam giac:");
        int a = Check(sc, "Canh thu 1: ");
        int b = Check(sc, "Canh thu 2: ");
        int c = Check(sc, "Canh thu 3: ");

        String triangleType = determineTriangleType(a, b, c);

        System.out.println("Triangle type: " + triangleType);
    }

    public static String determineTriangleType(int a, int b, int c) {
        if (isValidTriangle(a, b, c)) {
            if (a == b && b == c) {
                return "Equilateral"; // Tam giác đều
            } else if (a == b || a == c || b == c) {
                return "Isosceles"; // Tam giác cân
            } else {
                return "Scalene"; // Tam giác thường
            }
        } else {
            return "NotATriangle"; // Không phải tam giác
        }
    }

    public static boolean isValidTriangle(int side1, int side2, int side3) {
        return (side1 + side2 >= side3) && (side1 + side3 >= side2) && (side2 + side3 >= side1);
    }

    public static int Check(Scanner sc, String message){
        System.out.print(message);
        int d = sc.nextInt();
        while (d <= 0){
            System.out.print("Nhap lai: ");
            d = sc.nextInt();
        }
        return d;
    }
}