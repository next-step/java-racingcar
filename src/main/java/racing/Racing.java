package racing;

import java.util.List;

public class Racing {

    final int rounds;

    public Racing(int rounds) {
        this.rounds = rounds;
    }

    public void race(List<Car> cars) {
        int roundCount = rounds;
        while (roundCount-- > 0) {
            startRound(cars);
        }
    }

    // TODO: 단위 테스트 추가 방법을 생각해보자.
    private void startRound(List<Car> cars) {
        for (Car car : cars) {
            car.round();
        }
    }
}
