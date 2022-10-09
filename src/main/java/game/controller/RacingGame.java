package game.controller;

import game.controller.dto.CarsDto;
import game.controller.dto.GameParam;
import game.domain.Car;
import game.domain.Cars;
import game.domain.Winners;
import game.domain.movable.MovableStrategy;
import game.view.InputView;
import game.view.OutputView;

import java.util.stream.Collectors;

public class RacingGame {

    public void play(final MovableStrategy movableStrategy) {
        GameParam param = InputView.getGameParam();
        Cars cars = new Cars(param.getCarNames().stream()
                .map(Car::new)
                .collect(Collectors.toList()));
        OutputView.printOutputStart();
        for (int i = 0; i < param.getCountOfRound(); i++) {
            playRound(cars, movableStrategy);
        }
        OutputView.printWinners(CarsDto.from(Winners.findWinners(cars)));
    }

    private static void playRound(final Cars cars, final MovableStrategy movableStrategy) {
        cars.moveCarList(movableStrategy);
        OutputView.printOutputBody(CarsDto.from(cars));
    }

}
