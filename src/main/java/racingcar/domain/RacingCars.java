package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {
    private List<RacingCar> racingCars;

    RacingCars(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 한 개 이상 입력해야 합니다");
        }

        this.racingCars = racingCars;
    }

    void moveCars(List<Integer> randomNumbers) {
        if (randomNumbers.size() != racingCars.size()) {
            throw new IllegalArgumentException("경기 횟수와 동일한 크기의 숫자 리스트를 입력해주세요");
        }

        for (int i = 0; i < racingCars.size(); ++i) {
            if (randomNumbers.size() != racingCars.size()) {
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

    public int getSize() {
        return racingCars.size();
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
}
