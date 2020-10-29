package step3.controller;

import java.util.Scanner;

public class InputController {


    private static final Scanner scanner = new Scanner(System.in);

    public static int putCarCount(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }
    public static int putTryCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }


}
