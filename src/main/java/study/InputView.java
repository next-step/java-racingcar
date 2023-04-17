package study;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GUIDE_FOR_INPUT_NUMBER_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GUIDE_FOR_INPUT_NUMBER_OF_GAME = "시도할 회수는 몇 회 인가요?";

    public static GameInfo prepareGame() {
        guidForInputNumberOfCar();
        List<String> nameList = inputNameOfCar();
        guideForInputNumberOfGame();
        int numberOfGame = InputNumberOfGame();
        return new GameInfo(nameList, numberOfGame);
    }

    private static void guidForInputNumberOfCar() {
        System.out.println(GUIDE_FOR_INPUT_NUMBER_OF_CAR);
    }

    private static List<String> inputNameOfCar() {
        String inputName = SCANNER.nextLine();
        return StringSplitter.splitByComma(inputName);
    }

    private static void guideForInputNumberOfGame() {
        System.out.println(GUIDE_FOR_INPUT_NUMBER_OF_GAME);
    }


    private static int InputNumberOfGame() {
        return SCANNER.nextInt();
    }


}
