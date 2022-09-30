package racing.controller;

import racing.domain.Cars;
import racing.domain.RandomMovingStrategy;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.stream.IntStream;


public class Race
{
    private static Race race;
    private final InputView inputView;
    private final ResultView resultView;

    private int tryNumber;

    private Race()
    {
        this.inputView = InputView.getInstance();
        this.resultView = ResultView.getInstance();
    }

    public static Race setup()
    {
        if (race == null)
        {
            race = new Race();
        }
        return race;
    }

    public void start()
    {
        Cars cars = Cars.newCars(inputView.carName(), new RandomMovingStrategy());
        setTryNumber();
        IntStream.range(0, tryNumber)
                .forEach(tryNumber -> resultView.draw(tryNumber, cars.moving()));

        resultView.winnerDraw(cars);
    }

    private void setTryNumber()
    {
        this.tryNumber = inputView.tryNumber();

        if (tryNumber <= 0)
        {
            throw new IllegalArgumentException("시도 횟수는 0이하 일 수는 없습니다.");
        }
    }
}
