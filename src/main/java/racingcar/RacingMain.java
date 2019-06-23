package racingcar;

import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.utils.NumGenerator;
import racingcar.utils.RandomNumGenerator;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = Input.getCarNames();

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Input.getTimes();
        NumGenerator numGenerator = new RandomNumGenerator();

        RacingGame rg = new RacingGame(carNames, times, numGenerator);
        Cars racingCars = rg.run();
        racingCars.printWinners();

    }
}
