import domain.*;
import view.InputView;
import view.OutputView;

public class CarGame {
    public static void main(String[] args) {

        String names = InputView.inputCarNames();
        int carCnt = InputView.inputCarCnt();
        int playCnt = InputView.inputPlayCnt();

        Cars cars = Cars.of(names, carCnt);
        for (int i = 0; i < playCnt; i++) {
            for (Car car : cars.getCarList()) {
                OutputView.printLength(car.getName(), car.getLength());
                System.out.println();
                if (i != playCnt-1) car.go();
            }
            System.out.println();
        }
        Referee referee = new Referee(cars.getCarList());
        OutputView.printWinner(referee.getWinnersCarNames());

    }
}
