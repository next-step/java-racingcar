package racing.domain;

import racing.dto.RacingGameCreateRequest;

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

    public List<Integer> race() {
        currentTime += 1;
        return racingCars.stream()
                .map(RacingCar::rush)
                .collect(toList());
    }

    public boolean isRacingAvailable() {
        return totalTime > currentTime;
    }
}
