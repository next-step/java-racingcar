package step3.domain;

import step3.view.ResultView;

import java.util.List;

public class Play {

    private static final ResultView RESULT_VIEW = new ResultView();
    private static final RandomNumber RANDOM_NUMBER = new RandomNumber();
    private static final Winner WINNER = new Winner();
    
    public void playGame(String[] names, int count) {
        List<Car> carList = createCarList(names);
        for (int i = 0; i < count; i++) {
            run(carList);
            if (i == count - 1) {
                isLastGame(carList);
            }
        }
    }

    private List<Car> createCarList(String[] names) {
        Cars cars = new Cars(names);
        return cars.getCarList();
    }

    private void isLastGame(List<Car> carList) {
        RESULT_VIEW.winnerOutput(WINNER.decide(carList));
    }

    private void run(List<Car> carList) {
        carList.forEach(car -> car.moveCheck(RANDOM_NUMBER.randomNumber()));
        output(carList);
    }

    private void output(List<Car> carList) {
        RESULT_VIEW.output(carList);
    }
}
