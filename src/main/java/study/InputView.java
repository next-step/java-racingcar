package study;

import java.util.Scanner;

public class InputView {

    public InputView(){

    }

    public static String askCarCount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public static String askTryCount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }

}
