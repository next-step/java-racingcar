package study;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GUIDE_FOR_INPUT_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String GUIDE_FOR_INPUT_NUMBER_OF_GAME = "시도할 회수는 몇 회 인가요?";

    public static GameInfo prepareGame() {
        guidForInputNumberOfCar();
        int numberOfCar = InputNumberOfCar();
        guideForInputNumberOfGame();
        int numberOfGame = InputNumberOfGame();
        return new GameInfo(numberOfCar, numberOfGame);
    }

    private static void guidForInputNumberOfCar() {
        System.out.println(GUIDE_FOR_INPUT_NUMBER_OF_CAR);
    }

    private static int InputNumberOfCar() {
        return SCANNER.nextInt();
    }

    private static void guideForInputNumberOfGame() {
        System.out.println(GUIDE_FOR_INPUT_NUMBER_OF_GAME);
    }


    private static int InputNumberOfGame() {
        return SCANNER.nextInt();
    }


}
