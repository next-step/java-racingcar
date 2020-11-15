package carRace.step5.view;

import java.util.Scanner;

public class RaceInputView {

    private static String INPUT_CAR_RACE_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String HOW_MANY_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public static String inputRaceNames(){
        System.out.println(INPUT_CAR_RACE_NAMES);
        return scanner.nextLine();
    }

    public static String inputTryCount(){
        System.out.println(HOW_MANY_ATTEMPTS);
        return scanner.nextLine();
    }
}
