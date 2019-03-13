package racingcar.view;

import org.apache.commons.lang3.StringUtils;
import racingcar.car.Car;

import java.util.List;

public class OutputView {

    private static final String POSITION_BAR = "-";
    private static final String EMPTY_LINE = "";

    public static void showStatus(String name, int position) {
        System.out.print(name + " : ");
        System.out.println(StringUtils.repeat(POSITION_BAR, position));
    }

    public static void nextTurn() {
        System.out.println(EMPTY_LINE);
    }

    //TODO : 개선필요, 좋은방법 생각해볼 것
    public static void showWinner(List<Car> cars) {
        int count = cars.size();
        int i=0;

        for (i = 0; i < count-1; i++) {
            int res = cars.get(i).compareTo(cars.get(i+1));
            if (res < 0) break;

            System.out.print(cars.get(i).getName() + ", ");
        }
        System.out.println(cars.get(i).getName() + "가 최종 우승했습니다.");
    }
}
