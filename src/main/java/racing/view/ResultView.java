package racing.view;

import racing.Constant;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Winners;

public class ResultView {

    public static void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printCarPosition(Car car){
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(Constant.MARK);
        }
        System.out.println(sb);
    }

    public static void printWinner(Winners winners) {
        StringBuilder sb = new StringBuilder();
        for (Car car : winners.getWinners()) {
            if (sb.length() != 0) sb.append(Constant.CAR_NAME_DELIMITER);
            sb.append(car.getName());
        }
        sb.append(Constant.WINNER_MESSAGE);
        System.out.println(sb);
    }
}
