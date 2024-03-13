package carRace.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputRaceCarCount(){
        System.out.println("자동차 대수는 몇 대 인가요?\n");
        return scanner.nextInt();
    }

    public static int inputRaceTryCount(){
        System.out.println("시도할 회수는 몇 회 인가요\n");
        return scanner.nextInt();
    }
}
