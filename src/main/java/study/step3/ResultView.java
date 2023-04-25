package study.step3;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    void printStateBoard(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + printCarPosition(car.getPosition()));
        }
        System.out.println();
    }

    String printCarPosition(Position position) {
        return "-".repeat(position.getPosition());
    }

    void printWinner(Cars cars) {
        System.out.println(namesToString(cars.findWinnerNames()) + "가 최종 우승했습니다.");
    }

    private String namesToString(ArrayList<Name> names) {
        String winnerNames = "";
        for (Name name : names) {
            winnerNames += name.getName() + ",";
        }
        return winnerNames.substring(0, winnerNames.length() - 1);
    }


}
