package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.dto.CarResponseDto;
import racingcar.view.dto.NamesRequestDto;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.app.WebApp.carDao;

public class Service {

    public List<CarResponseDto> createCars(NamesRequestDto namesRequestDto) {
        carDao.save(namesRequestDto.toNameList());
        return carDao.findAll().stream().map(Car::toDto).collect(Collectors.toList());
    }

    public List<CarResponseDto> playRacingGame(Integer times) {
        List<Car> cars = carDao.findAll();
        RacingGame racingGame = new RacingGame(times);
        for (int i = 1; i <= racingGame.getTimes(); i++) {
            racingGame.race(cars, new RandomNumberGenerator());
        }
        return cars.stream().map(Car::toDto).collect(Collectors.toList());
    }

    public List<String> produceResult() {
        List<Car> cars = carDao.findAll();
        Referee referee = new Referee();
        return referee.pickNamesOfWinners(cars);
    }
}
