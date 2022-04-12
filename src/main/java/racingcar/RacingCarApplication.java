package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumber randomNumber = new RandomNumber();

        int carNumber = inputView.askNumberOfCars();
        int triesNumber = inputView.askNumberOfTries();

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
        }

        for (int i = 0; i < triesNumber; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).moveOrStop(randomNumber.createRandomNumber());
                outputView.printResult(carList.get(j));
            }
            System.out.println("======" + (i+1)+ "회 ======");
            System.out.println("");
        }




    }
}
