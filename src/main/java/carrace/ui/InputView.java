package carrace.ui;

import carrace.CarRace;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public CarRace makeCarRaceByInput() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        String carNames = scanner.nextLine();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfRaces = scanner.nextInt();

        return new CarRace(carNames, numberOfRaces);
    }
}
