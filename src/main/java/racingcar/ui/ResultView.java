package racingcar.ui;

import racingcar.model.Car;

import java.util.List;

public class ResultView {
    private static final String PRINT_DISTANCE = "-";
    private static final String NAME_DELIMITER = ": ";

    private static ResultView instance = new ResultView();

    private ResultView() {
        System.out.println("실행 결과");
    }

    public static ResultView getInstance() {
        return instance;
    }

    public void printMove(List<Car> carList) {
        carList.forEach(car -> printCarDistance(car));
    }

    private static void printCarDistance(Car car) {
        System.out.print(getCarName(car));
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(PRINT_DISTANCE);
        }
        System.out.println();
    }

    private static String getCarName(Car car) {
        return car.getName() + NAME_DELIMITER;
    }

    public void printLineBreak() {
        System.out.println();
    }

}
