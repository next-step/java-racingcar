package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.CarName;
import com.nextstep.racingcar.domain.Parser;
import com.nextstep.racingcar.domain.Race;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RaceManager {
    private static final int BOUND = 10;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public static void main(String[] args) {
        new RaceManager().run();
    }

    public void run() {
        Race race = createRace();
        int moveCount = inputMoveLimit();

        printResultHeader();
        for (int i = 0; i < moveCount; i ++) {
            List<Car> cars = race.moveAndGet();
            printPosition(cars);
        }
        printWinner(race.getWinnerNames());
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
            System.out.println(car.toDetailString());
        }
        System.out.println();
    }

    private Race createRace() {
        List<CarName> carNames = inputCarNames();
        return new Race(carNames, this::getRandomValue);
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
