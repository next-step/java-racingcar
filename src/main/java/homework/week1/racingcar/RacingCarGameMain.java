package homework.week1.racingcar;

import homework.week1.racingcar.domain.Car;
import homework.week1.racingcar.domain.Game;
import homework.week1.racingcar.domain.GameResult;
import homework.week1.racingcar.view.GameInputView;
import homework.week1.racingcar.view.GameResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameMain {
    public static void main(String[] args) {
        String carStrings = GameInputView.inputCarName();
        String numberOfRacing = GameInputView.inputNumberOfRacing();

        Game racingCarGame = new Game(carStrings, numberOfRacing);
        int tryNumberOfRacing = 0;
        List<Car> perRaceResultCars = new ArrayList<>();
        while (!racingCarGame.isFinishRace(tryNumberOfRacing)) {
            ++tryNumberOfRacing;
            perRaceResultCars = racingCarGame.tryRace();
            GameResultView.printRaceResultCars(GameResult.of(perRaceResultCars));
        }

        GameResult gameResult = GameResult.of(perRaceResultCars);
        GameResultView.printWinnerCars(gameResult.getWinnerNames(gameResult.getMaxPosition()));
    }
}
