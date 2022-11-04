package racingGame;
import racingGame.domain.Car;
import racingGame.dto.CarsDto;
import racingGame.strategy.NumberGenerateStrategy;
import racingGame.domain.Cars;
import java.util.List;
import java.util.stream.Collectors;

import static racingGame.view.ResultView.resultMessage;
import static racingGame.view.ResultView.racingResult;

public class RacingGame {
    private final NumberGenerateStrategy numberGenerateStrategy;
    private final Cars cars;
    private final int tryCount;

    public RacingGame(NumberGenerateStrategy numberGenerateStrategy, Cars cars, int tryCount){
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<String> race(){
        resultMessage();
        for(int i= 0; i < tryCount; i++){
            cars.carTryMove(numberGenerateStrategy);
            racingResult(CarsDto.makeCarsDto(cars));
        }
        return carWinners();
    }

    private List<String> carWinners(){
        return cars.getCars().stream()
                .filter(car -> car.isSamePosition(getMaxPostion()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPostion(){
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }


}