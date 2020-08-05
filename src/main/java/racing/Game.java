package racing;

import racing.domain.Car;
import racing.message.ViewMsg;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.stream.IntStream;

public class Game {
    public static ResultView resultView;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        resultView = new ResultView();
        Car[] cars = new Car[inputView.getCarCount()];
        int repeatCount = inputView.getrepeatCount();

        IntStream.range(0, cars.length).forEach(i -> {
            cars[i] = new Car();
        });

        resultView.viewResultMsg();

        for (int i=0; i<repeatCount; i++) {
            carRunWithView(cars);
            System.out.println(ViewMsg.END_LINE.getMsg());
        }
    }

    public static void carRunWithView(Car[] cars) {
        IntStream.range(0, cars.length).forEach(j -> {
            cars[j].run();
            System.out.println(resultView.getLocationVisualization(cars[j].getLocation()));
        });
    }
}
