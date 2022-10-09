package racing.core;

import racing.RandomUtil;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingApp {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Mover mover = new Mover();

    public RacingApp() {
    }

    public void start() {
        ClientInput racingDto = inputView.getClientInput();
        List<Car> carList = makeCarList(racingDto.getCarCount());
        resultView.printStartText();
        for (int i = 0; i < racingDto.getTryCount(); i++) {
            moveCars(carList);
            resultView.printCarList(carList);
        }
    }

    private List<Car> makeCarList(int size) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    private void moveCars(List<Car> carList) {
        carList.forEach(car -> {
            int randomNum = RandomUtil.getRandomNumUnder10();
            mover.decideMove(car, randomNum);
        });
    }
}
