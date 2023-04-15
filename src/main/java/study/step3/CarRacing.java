package study.step3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRacing {

    private int round;
    private int carCount;
    private Car[] cars;
    private Scanner scanner = new Scanner(System.in);

    public void startRacing() {
        initGame();
        playGame();
    }

    public void initGame() {
        carCount = readInputNum("자동차 대수는 몇 대 인가요?");
        round = readInputNum("시도할 횟수는 몇 회 인가요?");

        System.out.println("실행 결과");
        initCarObject();
    }

    private void initCarObject() {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    private void playGame() {
        for (int i = 0; i < round; i++) {
            moveCars();
            printStateBoard();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printStateBoard() {
        for (Car car : cars) {
            System.out.println(printCarState(car.getPosition()));
        }
        System.out.println();
    }

    String printCarState(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }


    private int readInputNum(String message) {
        System.out.println(message);
        return toInt(scanner.nextLine());
    }

    private int toInt(String str) {
        return Integer.valueOf(str);
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.startRacing();
    }

}
