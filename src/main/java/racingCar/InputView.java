package racingCar;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int receiveCarCount() {
        System.out.println("자동차 대수는 몇 대인가요?");

        while (true) {
            try {
                int carCount = scanner.nextInt();

                if (carCount <= 1) {
                    throw new NumberFormatException("2 ~ 9 사이의 양수를 입력해주세요.");
                }

                System.out.println(carCount);
                return carCount;
            } catch (NumberFormatException e) {
                System.out.println("2 ~ 9 사이의 유효한 숫자를 입력 해주세요.");
            }
        }

    }

    public int receiveRaceCount() {
        System.out.println("시도할 회수는 몇 회인가요?");

        while (true) {
            try {
                int raceCount = scanner.nextInt();


                validateRaceCount(raceCount);
                System.out.println(raceCount);
                return raceCount;
            } catch (NumberFormatException e) {
                System.out.println("1 ~ 9 사이의 유효한 숫자를 입력 해주세요.");
            }
        }

    }

    private void validateRaceCount(int raceCount) {
        if (raceCount <= 1) {
            throw new NumberFormatException("1 ~ 9 사이의 양수를 입력해주세요.");
        }
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
