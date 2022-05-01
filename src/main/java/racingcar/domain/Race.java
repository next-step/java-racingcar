package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    private int raceCount;
    private RacingCars racingCars;

    public Race(int raceCount, RacingCars racingCars) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException("경기 회수는 1 이상의 수를 입력해주세요");
        }

        this.raceCount = raceCount;
        this.racingCars = racingCars;
    }

    public void startRace(List<List<Integer>> randomNumbers) {
        for (int i = 0; i < raceCount; i++) {
            oneRound(randomNumbers.get(i));
        }
    }

    private void oneRound(List<Integer> randomNumbers) {
        racingCars.moveCars(randomNumbers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Race race = (Race) obj;
        return this.raceCount == race.raceCount && this.racingCars.equals(race.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCount, racingCars);
    }
}
