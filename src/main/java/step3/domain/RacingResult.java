package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 컬렉션 정보를 관리하는 레이싱 결과를 담는 클래스
 */
public class RacingResult {

    private final List<RacingRound> racingRounds;

    public RacingResult() {
        this.racingRounds = new ArrayList<>();
    }

    public void addRacingRound(final RacingRound racingRound) {
        this.racingRounds.add(racingRound);
    }

    public List<RacingRound> getRacingRounds() {
        return Collections.unmodifiableList(racingRounds);
    }

    // 레이싱 결과를 담는 클래스에 승자를 출력하기 위한 메서드
    public String[] getWinner() {
        RacingRound lastRound = getRacingRounds().get(racingRounds.size() - 1);
        List<Car> cars = lastRound.getCars();

        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();
    }
}
