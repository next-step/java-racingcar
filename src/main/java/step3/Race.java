package step3;

import step3.model.Cars;
import step3.model.RandomMovingStrategy;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.stream.IntStream;


public class Race
{
    private static Race race;
    private final InputView inputView;
    private final ResultView resultView;

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
        Cars cars = new Cars(inputView.carName(), new RandomMovingStrategy());

        IntStream.range(0, inputView.tryNumber())
                .forEach(tryNumber -> resultView.draw(tryNumber, cars.moving()));

        resultView.winnerDraw(cars);
    }
}
