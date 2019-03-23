package racing.domain;

import racing.dto.CarRoundResult;
import racing.dto.RacingGameRoundResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGameResult {
    private List<RacingGameRoundResult> racingGameRoundResult;

    public RacingGameResult(List<RacingGameRoundResult> racingGameRoundResult) {
        this.racingGameRoundResult = racingGameRoundResult;
    }

    public List<RacingGameRoundResult> printRoundHistory() {
        return this.racingGameRoundResult;
    }

    public List<CarRoundResult> findLastRoundCars() {
        int lastRound = racingGameRoundResult.size() - 1;
        RacingGameRoundResult lastRoundResult = racingGameRoundResult.get(lastRound);
        List<CarRoundResult> lastRoundCarResults = lastRoundResult.getCarResults();
        return lastRoundCarResults;
    }

    // 우승자 반환
    public List<String> findRacingWinner() {
        int lastRound = racingGameRoundResult.size() - 1;
        RacingGameRoundResult lastRoundResult = racingGameRoundResult.get(lastRound);
        List<CarRoundResult> carRoundResults = lastRoundResult.getCarResults();

        CarRoundResult maxCarRoundResult =
                carRoundResults.stream()
                        .max(Comparator.comparing(CarRoundResult::getMovePosition))
                        .get();

        List<CarRoundResult> carWinners =
                carRoundResults.stream()
                        .filter(x -> x.getMovePosition() == maxCarRoundResult.getMovePosition())
                        .collect(Collectors.toList());

        List<String> winners = new ArrayList<String>();
        carWinners.forEach(name -> winners.add(name.getCarName()));

        return winners;
    }
}