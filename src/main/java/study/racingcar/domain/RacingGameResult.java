package study.racingcar.domain;

import study.racingcar.domain.car.CarSnapshot;
import study.racingcar.domain.racingcars.RacingCars;
import study.racingcar.domain.racingcars.RacingCarsSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 진행동안 게임의 진행 상태와 결과를 보관하는 책임
 */
public class RacingGameResult {

    List<RacingCarsSnapshot> gameProgressSnapshots = new ArrayList<>();
    List<CarSnapshot> winners = new ArrayList<>();

    public void addGameProgressSnapshots(RacingCarsSnapshot racingCarsSnapshot) {
        this.gameProgressSnapshots.add(racingCarsSnapshot);
    }

    public void addWinners(List<CarSnapshot> winners) {
        this.winners.addAll(winners);
    }

    public List<RacingCarsSnapshot> getGameProgressSnapshots() {
        return gameProgressSnapshots;
    }

    public List<CarSnapshot> getWinners() {
        return winners;
    }

}
