package step3;

import step3.model.Cars;
import step3.model.RandomMovingStrategy;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.stream.IntStream;


public class Race
{
    public static void main(String[] args)
    {
        Race.start();
    }

    public static void start()
    {
        InputView inputView = InputView.getInstance();
        Cars cars = new Cars(inputView.carName(), new RandomMovingStrategy());

        ResultView resultView = ResultView.getInstance();
        IntStream.range(0, inputView.tryNumber())
                .forEach(tryNumber -> resultView.draw(tryNumber, cars.moving()));

        resultView.winnerDraw(cars);
    }
}
