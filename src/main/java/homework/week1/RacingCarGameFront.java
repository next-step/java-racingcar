package homework.week1;

import java.util.Scanner;

public class RacingCarGameFront {
    private static final String RUN_SYMBOL = "-";

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numbersOfCars = scanner.nextInt();
        System.out.println("경주 할 회수는 몇 회 인가요?");
        int numbersOfRacing = scanner.nextInt();
        RacingCarGameEngine carGameEngine = new RacingCarGameEngine(numbersOfRacing, new int[numbersOfCars]);
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

    /**
     * * UI 로직 기능3 : 사용자 입력으로 받은 경수 횟수 만큼 printMoveRacingCar 를 호출하는 void 리턴형이고 매개변수가 없는
     *   goRacingGame 매소드이다.
     * * UI 로직 기능4 : 사용자 입력값이 유효한 값이 올때까지 입력을 받도록 유도하는 void 리턴형 tryValidUserInputValue 매서드이다.
     *   valicateUserInputValue 의 호출결과 exception 을 catch 하여 사용자 입력받는 부분을 다시 호출하도록 한다.
     * * UI 로직 기능5 : 사용자가 원하는 정보를 입력하도록 유도하는 void 리턴형 doUserInputValue 매서드이다.
     */
}
