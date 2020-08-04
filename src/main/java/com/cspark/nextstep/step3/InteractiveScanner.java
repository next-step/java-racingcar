package com.cspark.nextstep.step3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InteractiveScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);
        String[] driverNames = inputView.script1();
        int numberOfRepeats = inputView.script2();

        System.out.println(String.format("자동차 %d대, %d회 실행 결과", driverNames.length, numberOfRepeats));
        MotorRace motorRace = new MotorRace(driverNames, numberOfRepeats);
        motorRace.game();

        List<Driver> wins = motorRace.podium();
        System.out.println(String.format("%s가 최종 우승했습니다.",
            wins.stream()
                .map(d -> d.getName())
                .collect(Collectors.joining(", ")))
        );
    }

}
