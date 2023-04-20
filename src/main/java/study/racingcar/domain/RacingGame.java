package study.racingcar.domain;

import study.racingcar.dto.CarDto;
import study.racingcar.dto.CarDtos;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> cars;
    private int numberOfGames;
    private int lastLapCheck;

    public RacingGame(RacingGameInputs racingGameInputs) {
        this.cars = SettingGame.createCars(racingGameInputs);
        this.numberOfGames = racingGameInputs.getNumberOfGames();
        this.lastLapCheck = 0;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void nextLap() {
        this.lastLapCheck++;
    }
    public boolean isOver() {

        return this.numberOfGames <= this.lastLapCheck;
    }

    public void moveCar() {

        for(Car car : this.cars) {

            car.move();
        }
    }

    public List<CarDto> getCarDtos() {
        return new CarDtos(this.cars.stream()
                .map(Car::getCarDto)
                .collect(Collectors.toList())
        ).getCarDtos();
    }
}
