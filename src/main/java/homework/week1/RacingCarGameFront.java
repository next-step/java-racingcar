package homework.week1;

import java.util.Scanner;

public class RacingCarGameFront {
    private static final String RUN_SYMBOL = "-";

    public static void main(String[] args) {
        RacingCarGameFront gameFront = new RacingCarGameFront();
        gameFront.startGame(gameFront);
    }

    void startGame(RacingCarGameFront gameFront) {
        RacingCarGameEngine carGameEngine = null;
        try {
            carGameEngine = gameFront.getRacingCarGameEngine();
            gameFront.goRacingGame(carGameEngine);
        } catch (IllegalArgumentException exception) {
            System.out.println("1이상의 숫자로 처음부터 다시 입력하세요!");
            System.out.println("---------------------------------");
            startGame(gameFront);
        }
    }

    RacingCarGameEngine getRacingCarGameEngine() throws IllegalArgumentException {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numbersOfCars = scanner.nextInt();
        System.out.println("경주 할 회수는 몇 회 인가요?");
        int numbersOfRacing = scanner.nextInt();
        validateUserInputValues(numbersOfCars, numbersOfRacing);
        return new RacingCarGameEngine(numbersOfRacing, new int[numbersOfCars]);
    }

    void validateUserInputValues(int numbersOfCars, int numbersOfRacing)
            throws IllegalArgumentException {
        if (numbersOfCars < 1 || numbersOfRacing < 1) {
            throw new IllegalArgumentException("반드시 1 이상의 숫자를 입력하세요!");
        }
    }

    void printRacingCar(int[] carPositions) {
        for (int carPosition : carPositions) {
            printRunCar(carPosition);
        }
        System.out.println();
    }

    void printRunCar(int runCount) {
        for (int count = 0; count < runCount; count++) {
            System.out.print(RUN_SYMBOL);
        }
        System.out.println();
    }

    void goRacingGame(RacingCarGameEngine carGameEngine) {
        for (int count = 0; count < carGameEngine.getNumbersOfRacing(); count++) {
            carGameEngine.move();
            printRacingCar(carGameEngine.getCarPositions());
        }
    }
}
