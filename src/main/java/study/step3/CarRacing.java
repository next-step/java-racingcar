package study.step3;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class CarRacing {

    private static final String NULL_INPUT = "입력값이 null 입니다";
    private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int carNumber = getNumber(CAR_QUESTION);
        int roundNumber = getNumber(ROUND_QUESTION);
        printRaceRecords(raceManager().manageRace(carNumber, roundNumber));
    }

    private static void printRaceRecords(String raceRecords) {
        System.out.println("실행 결과\n" + raceRecords);
    }

    private static int getNumber(String question) {
        System.out.println(question);
        return validation(scanner.nextLine());
    }

    private static int validation(String number) {
        return requireNumber(requireNonNull(number));
    }

    private static String requireNonNull(String number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
        return number;
    }

    private static int requireNumber(String number) {
        return Optional.of(Integer.parseInt(number))
                .orElseThrow(NumberFormatException::new);
    }

    private static RaceManager raceManager() {
        CarManager carManager = new CarManager();
        DriverRecruiter driverRecruiter = new DriverRecruiter();
        RoundManager roundManager = new RoundManager();
        RaceRecorder raceRecorder = new RaceRecorder();
        return new RaceManager(carManager, driverRecruiter, roundManager, raceRecorder);
    }
}
