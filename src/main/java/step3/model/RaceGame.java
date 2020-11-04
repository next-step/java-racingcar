package step3.model;

import step3.exception.NotFinishRaceGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RaceGame {

    private RacingCars racingCars;
    private GameRound round;

    public RaceGame(GameRound round, Commander commander) {
        this.round = round;
        createParticipantRacingCar(commander, round.getRound());
    }

    private void createParticipantRacingCar(Commander commander, int totalRound) {
        List<RacingCar> cars = new ArrayList<>();
        IntStream.range(0, round.getParticipantCar())
                .forEach(i -> cars.add(new RacingCar(commander)));
        this.racingCars = new RacingCars(cars, totalRound);
    }

    public boolean start() {
        while(!round.isAllRoundFinish()){
            play();
        }
        return round.isAllRoundFinish();
    }

    private void play() {
        for (int i = 0; i < round.getParticipantCar(); i++) {
            racingCars.moveForward(i);
        }
        round.roundFinish();
    }

    public RacingCars end() {
        if (!round.isAllRoundFinish()) {
            throw new NotFinishRaceGameException(round.getRound());
        }
        return racingCars;
    }


}
