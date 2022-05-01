package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 한 개 이상 입력해야 합니다");
        }

        this.racingCars = racingCars;
    }

    public static RacingCars of(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }

        return new RacingCars(racingCars);
    }

    void moveCars(RandomNumbers randomNumbers) {
        for (int i = 0; i < racingCars.size(); ++i) {
            if (!randomNumbers.hasSize(racingCars.size())) {
                throw new IllegalArgumentException("자동차 개수와 동일한 크기의 숫자 리스트를 입력해주세요");
            }

            racingCars.get(i).move(randomNumbers.get(i));
        }
    }

    int maxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            maxPosition = racingCar.maxPosition(maxPosition);
        }

        return maxPosition;
    }

    List<RacingCar> maxPositionCar(int maxPosition) {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.isMaxPosition(maxPosition)) {
                winners.add(racingCar);
            }
        }

        return winners;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RacingCars racingCars = (RacingCars) obj;

        return this.racingCars.equals(racingCars.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }

    @Override
    public String toString() {
        String result = "";
        for (RacingCar racingCar : racingCars) {
            result = result + racingCar.toString() + "\n";
        }

        return result + "\n";
    }
}
