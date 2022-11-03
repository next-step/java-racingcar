package racingGame;
import racingGame.dto.CarsDto;
import racingGame.strategy.NumberGenerateStrategy;
import racingGame.domain.Cars;
import java.util.List;

import static racingGame.view.ResultView.resultMessage;
import static racingGame.view.ResultView.racingResult;
import static racingGame.view.ResultView.racingWinner;

public class RacingGame {
    private final NumberGenerateStrategy numberGenerateStrategy;
    private final Cars cars;
    private final int tryCount;

    public RacingGame(NumberGenerateStrategy numberGenerateStrategy, List<String> carNames, int tryCount){
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.cars = Cars.makeCars(carNames);
        this.tryCount = tryCount;
    }

    public void race(){
        resultMessage();

        for(int i= 0; i < tryCount; i++){
            cars.carTryMove(numberGenerateStrategy);
            racingResult(CarsDto.makeCarsDto(cars));
        }

        racingWinner(cars.carWinner());
    }
}