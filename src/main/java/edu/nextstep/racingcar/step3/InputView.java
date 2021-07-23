package edu.nextstep.racingcar.step3;

import edu.nextstep.racingcar.step3.app.Car;
import edu.nextstep.racingcar.step3.app.Vehicle;
import edu.nextstep.racingcar.step3.util.RandomUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();

        System.out.println(QUESTION_NUMBER_OF_ATTEMPTS);
        int numberOfAttempts = scanner.nextInt();

        ResultView resultView = new ResultView(make(numberOfCars), numberOfAttempts);
        resultView.play();
    }

    private static List<Vehicle> make(Integer numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(idx -> new Car(10, 4, new RandomUtils()))
                .collect(Collectors.toList());
    }
}
