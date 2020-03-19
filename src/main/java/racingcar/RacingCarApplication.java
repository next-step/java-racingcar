package racingcar;

import java.util.Scanner;

import static racingcar.InputType.CAR;
import static racingcar.InputType.TRY;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomNumGenerator rng = new RandomNumGenerator();

        System.out.println("몇 대의 자동차로 게임을 진행하실 건가요?");
        Scanner scanner1 = new Scanner(System.in);
        String carCount = scanner1.nextLine();
        inputView.insertNumberIntoField(carCount, CAR);

        System.out.println("몇 회를 시도하실 건가요?");
        Scanner scanner2 = new Scanner(System.in);
        String tryCount = scanner2.nextLine();
        inputView.insertNumberIntoField(tryCount, TRY);

        Cars cars = new Cars(inputView);
        cars.moveTryCount(inputView, rng);
    }
}
