package racingcar;

import java.util.Scanner;

public class CarRacingMain {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        CarNameDecision carNameDecision = new CarNameDecision();
        Winner winner = new Winner();

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carName = scanner.nextLine();
        String[] carNames = carName.replaceAll(" ","").split(",");
        carNameDecision.Decision(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        racingCarGame.startRacing(count, carNameDecision.racingCars);
        winner.winnerDecision(carNameDecision.racingCars);

        System.out.println("최종 우승자: " + winner.winner);
    }
}

