package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRacing {
    public static void main(String[] args) {
        RacingWinner nonTestRacingCar = new RacingWinner();
        RacingCarGame racingCarGame = new RacingCarGame();
        List<RacingCar> racingCars = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carName = scanner.nextLine();
        String[] carNames = carName.split(",");
        for (int i = 0; i < carNames.length; i++) {
            RacingCar racingCar = new RacingCar(carNames[i]);
            racingCars.add(racingCar);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        int count = scanner.nextInt();

        racingCarGame.startRacing(count, racingCars);
        List<String> winnerList = new ArrayList<String>();
        winnerList = nonTestRacingCar.selectWinner(carNameArr);
        String winner = nonTestRacingCar.removeRegex(winnerList);

        System.out.println("최종 우승자: " + winner);
    }
}

