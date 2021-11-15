package carracing.view;

import carracing.util.Car;

import java.util.List;


/*
 * ResultView
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class ResultView {

    private static final String MOVED = "-";        /* 차량 움직임 */
    private static final String CAR_NAME = "%s : ";
    private static final String WINNER_CAR_FORMAT = "%s, ";
    private static final String LINE_BREAK = "%n";
    private static final String WINNER_PRINT_FORMAT = "%s가 최종 우승했습니다.";

    public void printRacing(List<Car> carList) {
        for (Car car : carList) {
            System.out.println();
            print(car);
        }
        System.out.println();
    }

    public void print(Car car) {
        System.out.printf(CAR_NAME, car.getName().getAlias());
        for (int i = 0; i < car.getDrivingHistory(); i++) {
            System.out.print(MOVED);
        }
    }

    public void printWinner(List<String> winnerCars) {
        System.out.println();
        if (winnerCars.size() == 0) {
            return;
        }
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < winnerCars.size() - 1; i++) {
            winners.append(String.format(WINNER_CAR_FORMAT, winnerCars.get(i)));
        }
        winners.append(winnerCars.get(winnerCars.size() - 1));
        System.out.printf(WINNER_PRINT_FORMAT + LINE_BREAK, winners);
    }

}
