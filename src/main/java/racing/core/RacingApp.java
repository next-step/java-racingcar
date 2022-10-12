package racing.core;

import racing.RandomUtil;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApp {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Mover mover = new Mover();
    private final Referee referee = new Referee();

    public void start() {
        ClientInput clientInput = inputView.getClientInput();
        CarList cars;
        try {
            cars = CarList.makeCars(clientInput.getCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        resultView.printStartText();
        for (int i = 0; i < clientInput.getTryCount(); i++) {
            moveCars(cars);
            resultView.printCarList(cars);
        }
        CarList winners = referee.getWinners(cars);
        resultView.printWinners(winners);
    }

    private void moveCars(CarList cars) {
        cars.getCarStream().forEach(car -> {
            int randomNum = RandomUtil.getRandomNumUnder10();
            mover.decideMove(car, randomNum);
        });
    }

}
