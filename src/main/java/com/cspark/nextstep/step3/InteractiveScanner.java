package com.cspark.nextstep.step3;

import java.util.Scanner;

public class InteractiveScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRepeats = scanner.nextInt();

        System.out.println(String.format("자동차 %d대, %d회 실행 결과", numberOfCars, numberOfRepeats));
        MotorRace motorRace = new MotorRace(numberOfCars, numberOfRepeats);
        motorRace.game();
    }

}
