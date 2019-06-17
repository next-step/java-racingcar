package com.java.jaeheon.step1;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("계산 수식을 입력하세요 : ");

        String input = sc.nextLine();

        Calculator calculator = new Calculator(input);
        System.out.println("계산 값 : " + calculator.run());

    }
}
