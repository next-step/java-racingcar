package racing.domain;

import racing.dto.RacingCarStatus;
import racing.dto.RacingGameCreateRequest;
import racing.dto.RacingGameStatus;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {
    private List<RacingCar> racingCars;
    private int totalTime;
    private int currentTime;

    public RacingGame(RacingGameCreateRequest request) {
        this.initRacingCars(request.getCarNames());
        this.totalTime = request.getTime();
        this.currentTime = 0;
    }

    private void initRacingCars(List<String> racingCarNames) {
        // 레이싱카 리스트 초기화
        racingCars = racingCarNames.stream()
                .map(RacingCar::new)
                .collect(toList());
    }

    public RacingGameStatus race() {
        currentTime += 1;

        List<RacingCarStatus> racingCarStatuses = racingCars.stream()
                .map(RacingCar::rush)
                .collect(toList());

        return new RacingGameStatus(racingCarStatuses);
    }

    public boolean isRacingAvailable() {
        return totalTime > currentTime;
    }

    public RacingGameStatus getRacingGameStatus() {
        List<RacingCarStatus> racingCarStatuses = racingCars.stream()
                .map(RacingCar::getRacingCarStatus)
                .collect(toList());

        return new RacingGameStatus(racingCarStatuses);
    }
}
