package step4.service;

import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.GameHistory;
import step4.domain.dto.GameHistoryDto;
import step4.service.dto.GameInformation;
import step4.strategy.MoveStrategy;
import step4.vo.Names;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Integer time;
    private final Names names;
    private final MoveStrategy moveStrategy;

    private Game(Names names, Integer time, MoveStrategy moveStrategy) {
        this.time = time;
        this.names = names;
        this.moveStrategy = moveStrategy;
    }

    public static Game of(GameInformation gameInformation, MoveStrategy moveStrategy) {
        return new Game(gameInformation.getNames(), gameInformation.getTime(), moveStrategy);
    }

    public GameHistoryDto start() {
        GameHistory gameHistory = new GameHistory();
        Cars cars = makeCars(names);

        //시작하기 전 상태 저장
        gameHistory.save(cars);

        for (int now = 0; now < this.time; now++) {
            cars = step(cars);
            gameHistory.save(cars);
        }

        gameHistory.makeWinner(time);
        return GameHistoryDto.of(gameHistory);
    }

    private Cars makeCars(Names names) {
        List<Car> carList = names.getNames().stream().map(Car::createWithDefaultPosition).collect(Collectors.toList());
        return Cars.create(carList);
    }

    private Cars step(Cars cars) {
        return cars.move(moveStrategy);
    }
}
