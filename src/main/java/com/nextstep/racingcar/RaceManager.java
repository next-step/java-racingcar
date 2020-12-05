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
        while(race.isNotFinished()) {
            List<Car> cars = race.moveAndGet();
            printPosition(cars);
        }
        printWinner(race.getFinishedCarNames());
    }

    private void printWinner(String names) {
        System.out.println(names + "가 최종 우승했습니다.");
    }

    private void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void printPosition(List<Car> carList) {
        for (Car car : carList) {
            String positionString = getPositionString(car.getPosition());
            System.out.println(car.getName() + " : " + positionString);
        }
        System.out.println();
    }

    private String getPositionString(int position) {
        return Stream.generate(() -> "-")
                .limit(position)
                .collect(Collectors.joining());
    }

    private Race createRace() {
        List<CarName> carNames = inputCarNames();
        int moveLimit = inputMoveLimit();

        return new Race(carNames, moveLimit, this::getRandomValue);
    }

    private List<CarName> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String line = scanner.nextLine();
        return Parser.parseCarNames(line);
    }

    private int inputMoveLimit() {
        System.out.println("시도할 회수는 몇 회 인가요>");
        return scanner.nextInt();
    }

    private int getRandomValue() {
        return random.nextInt(BOUND);
    }
}
