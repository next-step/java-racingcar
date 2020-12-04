package com.nextstep.racingcar;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceManager {
    private final int BOUND = 10;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public static void main(String[] args) {
        new RaceManager().run();
    }

    public void run() {
        Race race = createRace();

        printResultHeader();
        while(!race.isNotFinished()) {
            List<Car> cars = race.moveAndGet(this::getRandomValue);
            printPosition(cars);
        }
    }

    private void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void printPosition(List<Car> carList) {
        for (Car car : carList) {
            String positionString = getPositionString(car.getPosition());
            System.out.println(positionString);
        }
        System.out.println();
    }

    private String getPositionString(int position) {
        return Stream.generate(() -> "-")
                .limit(position)
                .collect(Collectors.joining());
    }

    private Race createRace() {
        int carCount = inputCarCount();
        int moveLimit = inputMoveLimit();

        return new Race(carCount, moveLimit);
    }

    private int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int inputMoveLimit() {
        System.out.println("시도할 회수는 몇 회 인가요>");
        return scanner.nextInt();
    }

    private int getRandomValue() {
        return random.nextInt(BOUND);
    }
}
