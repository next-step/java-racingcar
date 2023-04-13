package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRacing {

    private int round;
    private int carCount;
    private Car[] cars;

    Scanner scanner = new Scanner(System.in);

    public void startRacing() {
        initGame();

    }

    public void initGame() {
        carCount = readInputNum("자동차 대수는 몇 대 인가요?");
        round = readInputNum("시도할 횟수는 몇 회 인가요?");

        System.out.println("자동차 " + carCount + "대, " + round + " 라운드 레이싱 시작");
        cars = new Car[carCount];
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
