package org.tlh.junit5;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NextDateTest {
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
    void testInvalidDate(){
        String actual = NextDate.getNextDate(0,13,2000);

        assertEquals("Invalid date", actual);
    }

    @Test
    void testLeapYear(){
        int[] year = {2004,1900,2000};
        int count = 0;
        for (int y = 0; y< year.length; y++){
            if (NextDate.isLeapYear(year[y])){
                count++;
            }
        }
        int actual = count;
        assertEquals(2, actual);
    }

    @Test
    void testDaysInMonth2(){
        int[] year = {2004,1900,2000};
        int count = 0;
        for (int m=0; m< year.length; m++){
            if (NextDate.numberOfDaysInMonth(2,year[m]) == 29){
                count++;
            }
        }
        int actual = count;
        assertEquals(2, actual);
    }

    @Test
    void testDaysInMonth4_6_9_11(){
        int[] month = {4,6,9,11};
        int count = 0;
        for (int m=0; m< month.length; m++){
            if (NextDate.numberOfDaysInMonth(month[m],2000) == 30){
                count++;
            }
        }
        int actual = count;
        assertEquals(4, actual);
    }

    @Test
    void testDaysInMonth1_3_5_7_8_10_12(){
        int[] month = {1,3,5,7,8,10,12};
        int count = 0;
        for (int m=0; m< month.length; m++){
            if (NextDate.numberOfDaysInMonth(month[m],2000) == 31){
                count++;
            }
        }
        int actual = count;
        assertEquals(7, actual);
    }

    @Test
    void testNextDay(){
        String actual1 = NextDate.getNextDate(31,12,2000);
        assertEquals("1/1/2001", actual1);
    }
}