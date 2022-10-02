package step3;

import java.util.List;

public class Play {

    private static final ResultView RESULT_VIEW = new ResultView();

    public void playGame(List<Car> carList, int count) {
        for (int i = 0; i < count; i++) {
            run(carList);
            RESULT_VIEW.output(carList);
        }
    }

    private void run(List<Car> carList) {
        carList.forEach(Car::randomNumber);
    }
}
