package step5.utility;

import step5.model.Car;
import step5.model.Cars;
import step5.model.Winners;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private ResultView(){
        throw new AssertionError("생성자 생성 불가!");
    }

    public static void resultShow(Cars cars, int numOfTries) {
        for (int i = 0; i < numOfTries; i++) {
            eachTries(i, cars);
            System.out.println();
        }

        System.out.println("최종 승자는 "+
                            createWinnerNames(cars.findWinners().getWinner()));
    }

    private static void eachTries(int i, Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + ": ");
            ResultView.eachCarRecord(car.getRecordMove(i));
        }
    }

    private static void eachCarRecord(int length) {
        for (int j = 0; j < length; j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static String createWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return String.join(",",winnerNames);
    }
}
