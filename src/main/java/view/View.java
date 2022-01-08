package view;

import domain.Car;

import java.util.List;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_ENTER_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_ENTER_GAME_TURN = "시도할 회수는 몇회인가요?";
    private static final String MESSAGE_PRINT_TURN_RESULT = "실행 결과";
    private static final String MESSAGE_PRINT_WINNER = "가 최종 우승했습니다";
    private static final String IS = " : ";
    private static final String COMMA = ", ";
    private static final String ONE_MOVING = "-";

    public String enterCarsName() {
        System.out.println(MESSAGE_ENTER_CARS_NAME);
        return scanner.next();
    }

    public int enterGameTurn() {
        System.out.println(MESSAGE_ENTER_GAME_TURN);
        return scanner.nextInt();
    }

    public void printTurnStart() {
        System.out.println("\n" + MESSAGE_PRINT_TURN_RESULT);
    }

    public void printTurnResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + IS);
            printCarMoving(car.getDistance());
        }
        System.out.println();
    }

    public void printCarMoving(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(ONE_MOVING);
        }
        System.out.println();
    }

    public void printWinnerResult(List<String> winner) {
        System.out.print(winner.get(0));
        for (int i = 1; i < winner.size(); i++) {
            System.out.print(COMMA + winner.get(i));
        }
        System.out.println(MESSAGE_PRINT_WINNER);
    }
}
