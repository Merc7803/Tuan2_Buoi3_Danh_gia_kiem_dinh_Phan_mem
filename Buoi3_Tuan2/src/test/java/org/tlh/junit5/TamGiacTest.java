package org.tlh.junit5;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TamGiacTest {
    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    public void setUpInput() {
        String input = "";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(originalSystemIn);
    }


    @Test
    void testEquilateralTriangle() {
        testIn = new ByteArrayInputStream("3\n3\n3\n".getBytes());
        System.setIn(testIn);

        Scanner scanner = new Scanner(System.in);
        String result = TamGiac.determineTriangleType(TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""));

        assertEquals("Equilateral", result);
    }

    @Test
    void testIsoscelesTriangle() {
        testIn = new ByteArrayInputStream("3\n-1\n6\n3\n".getBytes());
        System.setIn(testIn);

        Scanner scanner = new Scanner(System.in);
        String result = TamGiac.determineTriangleType(TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""));

        assertEquals("Isosceles", result);
    }

    @Test
    void testScaleneTriangle() {
        testIn = new ByteArrayInputStream("3\n6\n0\n8\n".getBytes());
        System.setIn(testIn);

        Scanner scanner = new Scanner(System.in);
        String result = TamGiac.determineTriangleType(TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""));

        assertEquals("Scalene", result);
    }

    @Test
    void testNotATriangle() {
        testIn = new ByteArrayInputStream("3\n3\n7\n".getBytes());
        System.setIn(testIn);

        Scanner scanner = new Scanner(System.in);
        String result = TamGiac.determineTriangleType(TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""), TamGiac.Check(scanner, ""));

        assertEquals("NotATriangle", result);
    }


}