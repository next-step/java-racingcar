package race;

import java.util.Scanner;

public class SimpleRacingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCars = getCustomerInput(scanner, "자동차 대수는 몇 대 인가요? (1-10): ");
        int numOfAttempts = getCustomerInput(scanner, "시도할 회수는 몇 회 인가요? (1-10): ");

        System.out.println("입력된 자동차 대수: " + numOfCars);
        System.out.println("입력된 시도 횟수: " + numOfAttempts);

        scanner.close();

        RacingTrack racingGame = new RacingTrack(numOfCars, numOfAttempts);
        racingGame.startRace();
    }

    private static int getCustomerInput(Scanner scanner, String message) {
        int number;
        do {
            number = getNumber(scanner, message);
        } while (!isValid(number));
        return number;
    }

    private static int getNumber(Scanner scanner, String message) {
        System.out.print(message);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next(); // 잘못된 입력 방지 (버퍼 비우기)
        return -1;
    }

    private static boolean isValid(int number) {
        if (number >= 1 && number <= 10) {
            return true;
        }
        System.out.println("1에서 10까지의 숫자만 입력 가능합니다.");
        return false;
    }
}
