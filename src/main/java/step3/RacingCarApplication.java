package step3;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Participant;
import step3.domain.RacingGame;
import step3.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {
    private static final String COMMA = ",";

    public static void main(String[] args) {
        String names = InputView.inputCarNames();
        int gameRoundCount = InputView.inputGameRoundCount();
        System.out.println();

        start(names, gameRoundCount);
    }

    private static void start(String names, int gameRoundCount) {
        RacingGame racingGame = RacingGame.create(gameRoundCount, createParticipant(names));
        racingGame.start();
    }

    private static Participant createParticipant(String names) {
        List<Car> carList = new ArrayList<>();
        for (String name : splitCarNames(names)) {
            carList.add(Car.create(name));
        }
        Cars cars = Cars.join(carList);
        return Participant.join(cars);
    }

    private static String[] splitCarNames(String names) {
        return names.split(COMMA);
    }
}
