package step3;

import step3.cars.Cars;
import step3.cars.RacingCars;
import step3.input.ConsoleInputView;
import step3.input.InputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        InputView inputView = new ConsoleInputView();

        RacingCars.Factory racingCarsFactory = new RacingCars.Factory(inputView.answerToQuestion("자동차 대수는 몇 대 인가요?"));
        Cars cars = racingCarsFactory.cars();

        int numberOfGames = inputView.answerToQuestion("시도할 회수는 몇 회 인가요?");

        for (int i = 0; i < numberOfGames; i++) {
            cars = cars.carsWithTurnUsed();
            cars.printPosition();
            System.out.println();
        }

        BUFFERED_READER.close();
    }


}
