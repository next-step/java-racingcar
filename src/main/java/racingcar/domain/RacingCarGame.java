package racingcar.domain;

import racingcar.domain.dto.RacingResult;
import racingcar.domain.dto.RoundResult;
import racingcar.domain.dto.RoundScore;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.StrategyRandomMove;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RacingCarGame {
    private static final int FIRST_INDEX = 0;

    private final StrategyRandomMove strategyRandomMove = new StrategyRandomMove();
    private final Map<Participant, Car> racingCars;

    public RacingCarGame(Map<Participant, Car> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCarGame from(Participants participants) {
        return new RacingCarGame(createRacingCars(participants));
    }
    public static Map<Participant, Car> createRacingCars(Participants participants) {
        return StreamSupport.stream(participants.spliterator(), false)
                .collect(Collectors.toMap(
                        participant -> participant,
                        participant -> Car.from(participant),
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));
    }

    public RacingResult executeRacing(int trialCount) {
        List<RoundResult> roundResults = new ArrayList<>();
        while (trialCount-- > 0) {
            roundResults.add(executeRound());
        }
        return new RacingResult(roundResults, selectWinners());
    }

    public RoundResult executeRound() {
        play(strategyRandomMove);
        return new RoundResult(getRoundResults());
    }

    private List<RoundScore> getRoundResults() {
        return racingCars.keySet().stream()
                .map(participant -> new RoundScore(participant.getName(), racingCars.get(participant).getPosition()))
                .collect(Collectors.toList());
    }

    private void play(MoveStrategy moveStrategy) {
        racingCars.keySet().forEach(participant -> racingCars.get(participant).moveForward(moveStrategy));
    }

    private Participants selectWinners() {
        int winnerPosition = calculateWinnerPosition();
        List<Participant> winners = new ArrayList<>();

        for (Participant participant : racingCars.keySet()) {
            selectWinner(winners, participant, winnerPosition);
        }

        return new Participants(winners);
    }

    private void selectWinner(List<Participant> winners, Participant participant, int winnerPosition) {
        if (racingCars.get(participant).isWinner(winnerPosition)) {
            winners.add(participant);
        }
    }

    private int calculateWinnerPosition() {
        List<Car> carList = new ArrayList<>(racingCars.values());
        carList.sort(Comparator.reverseOrder());
        Car firstCar = carList.get(FIRST_INDEX);

        return firstCar.getPosition();
    }
}

