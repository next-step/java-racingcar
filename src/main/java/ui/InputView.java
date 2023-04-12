package ui;

import java.util.Scanner;

public class InputView {

    public static void askForCarSize(){
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void askForTrySize(){
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int getCarSize() {
        int carSize =  new Scanner(System.in).nextInt();
        return carSize;
    }

    public static int getTrySize() {
        int trySize =  new Scanner(System.in).nextInt();
        return trySize;
    }
}
