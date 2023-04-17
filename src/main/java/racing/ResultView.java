package racing;

import java.util.List;

public class ResultView {

    public static final String MARK = "-";

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printRace(Cars cars) {
        List<Car> carList = cars.values();
        for (Car car : carList) {
            System.out.println(car.name() + " : " + convertPositionToMark(car.position()));
        }
        System.out.println();
    }

    private static String convertPositionToMark(int position) {
        return MARK.repeat(position);
    }

    public static void showWinner(Cars cars) {
        System.out.println(cars.winnerNames() + "가 최종 우승했습니다.");
    }
}
