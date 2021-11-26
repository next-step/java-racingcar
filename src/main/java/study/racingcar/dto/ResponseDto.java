package study.racingcar.dto;

import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;

import java.util.List;

public class ResponseDto {
    private List<Cars> resultCars;
    private List<Car> resultWinner;

    public ResponseDto(List<Cars> resultCars, List<Car> resultWinner) {
        this.resultCars = resultCars;
        this.resultWinner = resultWinner;
    }

    public List<Cars> getResultCars() {
        return resultCars;
    }

    public List<Car> getResultWinner() {
        return resultWinner;
    }
}
