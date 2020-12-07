package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceManager {
    private static final int BOUND = 10;
    private static final String MARK = "-";
    private static final String DELIMITER = " : ";

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public static void main(String[] args) {
        new RaceManager().run();
    }

    public void run() {
        Race race = createRace();

        printResultHeader();
        race.run();
        printRaceRecords(race.getRaceRecords());
        printWinner(race.getWinnerNames());
    }

    private void printWinner(String names) {
        System.out.println(names + "가 최종 우승했습니다.");
    }

    private void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private Race createRace() {
        List<CarName> carNames = inputCarNames();
        int moveCount = inputMoveLimit();

        return new Race(carNames, moveCount, this::getRandomValue);
    }

    private void printRaceRecords(List<RaceRecord> raceRecords) {
        for (RaceRecord raceRecord : raceRecords) {
            raceRecord.forEach(this::printCarRecord);
            System.out.println();
        }
    }


    private void printCarRecord(CarRecord record) {
        String carName = record.getName();
        int carPosition = record.getPosition();
        System.out.println(carName + DELIMITER + getPositionString(carPosition));
    }

    private String getPositionString(int position) {
        return Stream.generate(() -> MARK)
                .limit(position)
                .collect(Collectors.joining());
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
