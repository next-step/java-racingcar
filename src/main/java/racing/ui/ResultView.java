package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String NEW_LINE_TEXT = System.getProperty("line.separator");

    private ResultView() {
    }

    public static void printEntireStatus(final List<Cars> snapshots) {
        StringBuffer competitionStatus = new StringBuffer();
        competitionStatus.append("실행 결과");
        competitionStatus.append(NEW_LINE_TEXT);

        for (Cars cars : snapshots) {
            competitionStatus.append(getRoundStatus(cars));
            competitionStatus.append(NEW_LINE_TEXT);
        }

        System.out.println(competitionStatus.toString());
    }

    private static String getRoundStatus(final Cars snapshot) {
        StringBuffer roundStatus = new StringBuffer();
        for (Car car : snapshot.getCars()) {
            roundStatus.append(car.getName() + " : ");
            roundStatus.append(getCarStatus(car));
            roundStatus.append(NEW_LINE_TEXT);
        }

        return roundStatus.toString();
    }

    private static String getCarStatus(Car car) {
        StringBuffer carStatus = new StringBuffer();
        for (int i = 0, len = car.getDistance(); i < len; i++) {
            carStatus.append("-");
        }

        return carStatus.toString();
    }

    public static void printWinneringCars(final List<Car> winningCars) {
        StringBuffer winningCarsName = new StringBuffer();
        for (Car winningCar : winningCars) {
            winningCarsName.append(winningCar.getName() + ", ");
        }
        winningCarsName.deleteCharAt(winningCarsName.lastIndexOf(", "));

        System.out.println(winningCarsName.toString() + "가 최종 우승했습니다.");
    }
}
