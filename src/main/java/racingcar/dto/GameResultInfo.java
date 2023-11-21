package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class GameResultInfo {

    private final List<RacingCarDto> racingCarDtos;
    private final NumberOfAttempts leftNumberOfAttempts;

    private GameResultInfo(List<RacingCarDto> racingCarDtos, NumberOfAttempts leftNumberOfAttempts) {
        this.racingCarDtos = racingCarDtos;
        this.leftNumberOfAttempts = leftNumberOfAttempts;
    }

    public static GameResultInfo valueOf(RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        List<RacingCarDto> racingCarDtos = new ArrayList<>();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            racingCarDtos.add(new RacingCarDto(racingCar.getCarName(), racingCar.getPosition()));
        }
        return new GameResultInfo(racingCarDtos, numberOfAttempts);
    }


    public List<RacingCarDto> getRacingCarDtos() {
        return racingCarDtos;
    }

    public NumberOfAttempts getLeftNumberOfAttempts() {
        return leftNumberOfAttempts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResultInfo that = (GameResultInfo) o;
        return Objects.equals(racingCarDtos, that.racingCarDtos) && Objects.equals(leftNumberOfAttempts,
                that.leftNumberOfAttempts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarDtos, leftNumberOfAttempts);
    }
}
