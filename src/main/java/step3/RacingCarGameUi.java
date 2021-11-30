package step3;

import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.util.stream.Collectors;

public class RacingCarGameUi {
    String BAR = "-";
    Scanner scanner;

    public RacingCarGameUi() {
        scanner = new Scanner(System.in);
    }

    public int askRacingCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public String askRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int askAttemptNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void printExecuteResult() {
        System.out.println("실행 결과");
    }

    public void printRacingCarNameAndGameResult(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            System.out.println(racingCar.getName() + ":" + printRacingCarDistance(racingCar.getDistance()));
        }
        System.out.println();
    }

    public void printRacingCarWinnerResult(List<RacingCar> winnerRacingCarList) {
        System.out.println(printRacingCarWinnerName(winnerRacingCarList) + "가 최종 우승했습니다.");
    }

    public String printRacingCarWinnerName(List<RacingCar> winnerRacingCarList) {
        return winnerRacingCarList.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(","));
    }

    public void printRacingCarGameResult(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            System.out.println(printRacingCarDistance(racingCar.getDistance()));
        }
        System.out.println();
    }

    public String printRacingCarDistance(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        while (distance > 0) {
            stringBuilder.append(BAR);
            distance--;
        }
        return stringBuilder.toString();
    }

}
