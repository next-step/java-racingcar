package carracing.view;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.Winners;


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

    public void printRacing(Cars carList) {
        for (Car car : carList.getCars()) {
            System.out.println();
            print(car);
        }
        System.out.println();
    }

    public void print(Car car) {
        System.out.printf(CAR_NAME, car.getName().getAlias());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(MOVED);
        }
    }

    public void printWinner(Winners winnerCars) {
        System.out.println();
        StringBuilder winners = new StringBuilder();
        for (Car car : winnerCars.getWinners()) {
            winners.append(String.format(WINNER_CAR_FORMAT, car.getName().getAlias()));
        }
        winners.deleteCharAt(winners.length() - 2);
        System.out.printf(WINNER_PRINT_FORMAT + LINE_BREAK, winners);
    }

}
