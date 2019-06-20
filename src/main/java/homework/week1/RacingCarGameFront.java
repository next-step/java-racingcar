package homework.week1;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameFront {

    private static final String RUN_SYMBOL = "-";

    public static void main(String[] args) {
        RacingCarGameFront gameFront = new RacingCarGameFront();
        RacingCarGameEngine gameEngine = new RacingCarGameEngine();
        gameFront.setInputValue(gameEngine);

    }

    void setInputValue(RacingCarGameEngine gameEngine) {
        String carStr = getInputCarStrs();
        gameEngine.checkEmptyString(carStr);
        String[] carNames = gameEngine.splitInput(carStr);
        gameEngine.checkEmptyCarNames(carNames);
        int numberOfRacing = getInputNumberOfRacing();
        gameEngine.checkInputPositiveNum(numberOfRacing);
        gameEngine.initialize(carNames, numberOfRacing);
    }

    String getInputCarStrs() {
        printGuideStr("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    int getInputNumberOfRacing() {
        printGuideStr("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    void printRunCar(int runCount) {
        for (int count = 0; count < runCount; count++) {
            System.out.print(RUN_SYMBOL);
        }
        printEmptyLine();
    }

    void printRacingCars(List<Integer> carsRunCount) {
        for (int runCount : carsRunCount) {
            printRunCar(runCount);
        }
        printEmptyLine();
    }

    void goRacingGame(RacingCarGameEngine carGameEngine) {
        for (int count = 0; count < carGameEngine.getNumberOfRacing(); count++) {
            carGameEngine.move();
            printRacingCars(carGameEngine.getCarsRunCount());
        }
    }

    void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }

    void printEmptyLine() {
        System.out.println();
    }

}
