package racingcar.domain;

import racingcar.domain.exception.AlreadyTerminateRaceGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RaceGame {

    private RacingCars racingCars;
    private GameRound gameRound;
    private Commander commander;
    private int participantCars;

    public RaceGame(String[] carsNames, int totalRound, Commander commander) {
        this.gameRound = new GameRound(totalRound);
        this.participantCars = carsNames.length;
        this.commander = commander;
        createSetupRaceGame(carsNames);
    }

    private void createSetupRaceGame(String[] carNames) {
        List<RacingCar> cars = new ArrayList<>();
        IntStream.range(0, carNames.length)
                .forEach(i -> cars.add(new RacingCar(carNames[i])));
        racingCars = new RacingCars(cars);
    }

    public RacingCars start() {
        if (gameRound.isAllRoundFinish()) {
            throw new AlreadyTerminateRaceGameException();
        }
        roundPlay();
        return racingCars;
    }

    private void roundPlay() {
        for (int i = 0; i < participantCars; i++) {
            racingCars.roundExecute(i, commander);
        }
        gameRound.roundFinish();
    }

}
