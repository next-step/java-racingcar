package study.step3.dto;

import java.util.List;

public class CarRacingDto {

    private List<Integer> positionOfCars;

    public CarRacingDto(List<Integer> positionOfCars) {
        this.positionOfCars = positionOfCars;
    }

    public List<Integer> getPositionOfCars() {
        return positionOfCars;
    }

    public void setPositionOfCars(List<Integer> positionOfCars) {
        this.positionOfCars = positionOfCars;
    }
}
