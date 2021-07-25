package edu.nextstep.racingcar.step3;

import edu.nextstep.racingcar.step3.view.InputView;
import edu.nextstep.racingcar.step3.view.ResultView;

import java.util.Scanner;

public class App {

    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    private static final Integer NUMBER_OF_RANDOMS = 10;
    private static final Integer THRESHOLD = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();

        System.out.println(QUESTION_NUMBER_OF_ATTEMPTS);
        int numberOfAttempts = scanner.nextInt();

        InputView inputView = new InputView(numberOfCars);
        ResultView resultView = new ResultView(numberOfAttempts);

        resultView.play(inputView.make(NUMBER_OF_RANDOMS, THRESHOLD));
    }
}
