package racingcar.app;

import racingcar.dao.CarDao;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.CarResponseDto;
import racingcar.view.dto.CarsResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();

        RacingGame racingGame = new RacingGame(inputView.getTimes());
        Referee referee = new Referee();

        CarDao carDao = new CarDao();
        carDao.save(inputView.getNames());

        List<Car> racers = carDao.findAll();
        OutputView.printIntroduction();
        List<CarsResponseDto> interim = new ArrayList<>();
        while (!racingGame.isEnd()) {
            racingGame.race(racers, new RandomNumberGenerator());
            interim.add(new CarsResponseDto(
                    racers.stream()
                            .map(CarResponseDto::new)
                            .collect(Collectors.toList())));
        }

        List<String> namesOfWinners = referee.pickNamesOfWinners(racers);
        OutputView.printResult(interim, namesOfWinners);
    }
}
