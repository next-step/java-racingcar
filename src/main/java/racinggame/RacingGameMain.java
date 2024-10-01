package racinggame;

import racinggame.domain.RacingCar;
import racinggame.domain.RacingGame;
import racinggame.domain.RacingGameResult;
import racinggame.random.RacingGameRandomNumberGenerator;
import racinggame.ui.*;

import java.util.ArrayList;
import java.util.List;

public class RacingGameMain {
    public static void main(String[] args) {
        final MessageReader reader = new RacingMessageReader(System.in);
        final MessageWriter writer = new RacingMessageWriter();

        final RacingGame racingGame = settingRacingGame(reader, writer);
        final List<RacingGameResult> results = racingGame.play();

        final RacingGameResultView racingGameResultView = new RacingGameResultView(results, "-", writer);
        racingGameResultView.display();
    }

    private static RacingGame settingRacingGame(final MessageReader reader, final MessageWriter writer) {
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, writer);
        final int carCount = racingGameInputView.inputRacingCarCount();
        final int roundCount = racingGameInputView.inputRacingRoundCount();
        return new RacingGame(createRacingCars(carCount), roundCount);
    }

    public static List<RacingCar> createRacingCars(final int carCount) {
        final ArrayList<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            final RacingGameRandomNumberGenerator generator = new RacingGameRandomNumberGenerator();
            final RacingCar racingCar = new RacingCar(generator);
            racingCars.add(racingCar);
        }

        return racingCars;
    }
}
