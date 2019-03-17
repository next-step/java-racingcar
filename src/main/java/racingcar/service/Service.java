package racingcar.service;

import racingcar.dao.CarDao;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.dto.CarResponseDto;
import racingcar.view.dto.NamesRequestDto;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private static CarDao carDao = new CarDao();

    public List<CarResponseDto> createCars(NamesRequestDto namesRequestDto) {
        carDao.save(namesRequestDto.toNameList());
        return carDao.findAll().stream().map(CarResponseDto::new).collect(Collectors.toList());
    }

    public List<CarResponseDto> playRacingGame(Integer times) {
        List<Car> cars = carDao.findAll();
        RacingGame racingGame = new RacingGame(times);
        while (racingGame.isEnd()) {
            racingGame.race(cars, new RandomNumberGenerator());
        }
        return cars.stream().map(CarResponseDto::new).collect(Collectors.toList());
    }

    public List<String> produceResult() {
        List<Car> cars = carDao.findAll();
        Referee referee = new Referee();
        return referee.pickNamesOfWinners(cars);
    }
}
