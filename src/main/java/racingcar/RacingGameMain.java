package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static racingcar.CarConstant.*;

public class RacingGameMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RacingGame racingGame = new RacingGame();
        WinnerExtraction winnerExtraction = new WinnerExtraction();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInput = scanner.nextLine();
        String[] carNameArr = userInput.split(",");

        List<Car> carList = new ArrayList<>();

        for (String carName : carNameArr) {
            Car car = new Car(carName.trim());
            carList.add(car);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            racingGame.playRacing(carList);
            System.out.println();
        }

        List<String> winners = winnerExtraction.getWinners(carList);

        String winnerString = String.join(WIN_CAR_OUTPUT_DELIMITER, winners);
        System.out.println("최종 우승자 : " + winnerString);
    }

}
