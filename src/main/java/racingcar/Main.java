package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        NonTestRacingCar nonTestRacingCar = new NonTestRacingCar();

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carName = scanner.nextLine();
        racingCar.nameCheck(carName);
        String[] carNameArr = racingCar.carStringtoArray(carName);

        System.out.println("시도할 횟수는 몇 회인가요?");

        int count = scanner.nextInt();
        nonTestRacingCar.startRacing(count, carNameArr);
        List<String> winnerList = new ArrayList<String>();
        winnerList = nonTestRacingCar.selectWinner(carNameArr);
        String winner = nonTestRacingCar.removeRegex(winnerList);

        System.out.println("최종 우승자: " + winner);
    }
}

