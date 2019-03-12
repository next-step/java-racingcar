package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.car.Car;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String POSITION_BAR = "-";
    private static final String EMPTY_LINE = "";

    private static int topPosition=0;

    public static void showStatus(String name, int position) {
        System.out.print(name + " : ");
        System.out.println(StringUtils.repeat(POSITION_BAR, position));
    }

    public static void nextTurn() {
        System.out.println(EMPTY_LINE);
    }

    //TODO : 개선필요,, 좋은방법 생각해볼 것
    public static void showWinner(List<Car> cars, int topPosition) {
        sortRanking(cars);

        int winner = countWinner(cars, topPosition);

        for (int i = 0; i < winner - 1; i++) {
            System.out.print(cars.get(i).getName() + ", ");
        }
        System.out.println(cars.get(winner - 1).getName() + "가 최종 우승했습니다.");

    }

    //TODO : 여기부터 별도 class로 분리필요? view의 기능으로 보고 우선 여기 작성
    public static void sortRanking(List<Car> cars) {
        Collections.sort(cars);
    }

    private static int countWinner(List<Car> cars, int topPosition) {
        int winner = 0;
        for (Car car : cars) {
            winner += isWinner(car, topPosition);
        }
        return winner;
    }

    private static int isWinner(Car car, int topPosition) {
        if (car.isWinner(topPosition)) {
            return 1;
        }
        return 0;
    }
}
