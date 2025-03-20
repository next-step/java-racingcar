package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    // RacingGame:
    // - 각 자동차는 전진한다.
    // - 시도 횟수 만큼 게임 반복:
    // -- 각 게임에서 자동차 수 만큼 반복:
    // --- 각 자동차는 전진한다.
    // -- 한 게임 마무리 후 결과 저장
    // - 최종 결과 return
    private final List<Car> cars;

    public RacingGame(int carCount) {
        cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<List<String>> play(int roundCount) {
        List<List<String>> FinalResults = new ArrayList<>();

        for(int i = 0; i < roundCount; i++) {
            List<String> RoundResults = new ArrayList<>();
            for(Car car : cars) {
                car.move();
                RoundResults.add(car.move());
            }
            FinalResults.add(RoundResults);
        }

        return FinalResults;
    }
}
