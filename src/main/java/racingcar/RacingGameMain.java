package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGameMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        RacingGame racingGame = new RacingGame();
        WinnerExtraction winnerExtraction = new WinnerExtraction();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();
        String[] carNameArr = carName.split(", ");

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNameArr.length; i++) {
            Car car = new Car(carNameArr[i], 0);
            carList.add(car);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            racingGame.playRacing(random, carList);
            System.out.println();
        }

        int maxPosition = winnerExtraction.getMaxPosition(carList);

        List<Car> winners = winnerExtraction.getWinners(carList, maxPosition);

        StringBuilder winnerString = new StringBuilder();
        for (Car winner : winners) {
            winnerString.append(winner.getCarName()).append(", ");
        }

        System.out.println("최종 우승자 : " + winnerString.substring(0, winnerString.length() - 2));
    }

}
