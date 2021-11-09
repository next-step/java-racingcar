package step3;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Participant;
import step3.domain.RacingGame;
import step3.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int gameRoundCount = InputView.inputGameRoundCount();
        System.out.println();

        start(carCount, gameRoundCount);
    }

    private static void start(int carCount, int gameRoundCount) {
        RacingGame racingGame = RacingGame.create(gameRoundCount, createParticipant(carCount));
        racingGame.start();
    }

    private static Participant createParticipant(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int count = 0; count < carCount; count++) {
            carList.add(Car.create());
        }
        Cars cars = Cars.join(carList);
        return Participant.join(cars);
    }
}
