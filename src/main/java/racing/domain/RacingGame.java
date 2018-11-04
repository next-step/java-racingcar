package racing.domain;

import racing.dto.RacingCarStatus;
import racing.dto.RacingGameCreateRequest;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {
    List<RacingCar> racingCars;
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

    public List<RacingCarStatus> race() {
        currentTime += 1;
        return racingCars.stream()
                .map(RacingCar::rush)
                .collect(toList());
    }

    public boolean isRacingAvailable() {
        return totalTime > currentTime;
    }

    public List<String> getWinner() {
        if (racingCars.size() <= 0) {
            throw new IllegalStateException("대상 자동차가 존재하지 않습니다.");
        }

        int maxValue = racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(r -> r.getPosition() == maxValue)
                .map(RacingCar::getName)
                .collect(toList());
    }
}
