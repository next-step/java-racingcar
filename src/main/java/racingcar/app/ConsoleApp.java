package racingcar.app;

import racingcar.dao.CarDao;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

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
        racingGame.repeat(racers, new RandomNumberGenerator());

        List<String> namesOfWinners = referee.pickNamesOfWinners(racers);
        OutputView.printResult(namesOfWinners);
    }
}
