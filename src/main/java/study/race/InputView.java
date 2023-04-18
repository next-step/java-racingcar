package study.race;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String scanNumberOfCar() {
        System.out.println("자동차 대 수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public static int  scanNumberOfCount(){
        System.out.println("시도할 횟 수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
