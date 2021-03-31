package io.zbc.learning.java;

import java.util.Scanner;

public class ScannerLearning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.printf("Hi %s, you are %d!", name ,age);
    }
}
