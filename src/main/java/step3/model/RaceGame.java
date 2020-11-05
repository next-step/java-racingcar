package step3.model;

import step3.exception.AlreadyTerminateRaceGameException;
import step3.exception.NotFinishRaceGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceGame {

    private List<RacingCar> racingCars;
    private GameRound round;

    public RaceGame(GameRound round, Commander commander) {
        this.round = round;
        createParticipantRacingCar(commander);
    }

    private void createParticipantRacingCar(Commander commander) {
        racingCars = new ArrayList<>();
        IntStream.range(0, round.getParticipantCar())
                .forEach(i -> racingCars.add(new RacingCar(commander)));
    }

    public void start() {
        if(round.isAllRoundFinish()) {
            throw new AlreadyTerminateRaceGameException();
        }
        play();

    }

    private void play() {
        for (int i = 0; i < round.getParticipantCar(); i++) {
            racingCars.get(i).executeMoveTrack();
        }
        round.roundFinish();
    }

    public List<Integer> getMoveTracks() {
        return racingCars.stream()
                .map(RacingCar::movePosition)
                .collect(Collectors.toList());
    }
}
