package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Constant;

public class ResultView {

    public void printStates(List<Car> carList) {
        carList.forEach(car -> {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }

    public void printWinner(List<String> winnerList) {
        System.out.print(Constant.FINAL_WINNER);
        System.out.println(String.join(", ", winnerList));
    }
}
