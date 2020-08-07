import domain.*;
import view.InputView;

public class CarGame {
    public static void main(String[] args) {

        String names = InputView.inputCarNames();
        int carCnt = InputView.inputCarCnt();
        int playCnt = InputView.inputPlayCnt();

        Cars cars = Cars.of(names, carCnt, playCnt);
        cars.play();
    }
}
