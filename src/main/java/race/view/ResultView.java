package race.view;

import race.Car;
import race.CarName;
import race.Cars;

import java.util.List;

public class ResultView {
    private static final char POSITION_CHARACTER = '-';

    public static void showResultComment() {
        System.out.println("실행 결과");
    }

    public static void showCars(Cars cars) {
        for (Car car : cars.getCarList()) {
            showCar(car);
        }
        System.out.println();
    }

    private static void showCar(Car car) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(car.getCarName().get())
                .append(" : ");
        System.out.print(stringBuilder);
        for (int i = 0; i < car.getPosition().get(); i++) {
            System.out.print(POSITION_CHARACTER);
        }
        System.out.println();
    }

    public static void showWinners(List<CarName> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(getCommaIndexCondition(i));
            stringBuilder.append(winners.get(i).get());
        }
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    private static String getCommaIndexCondition(int i) {
        if (i > 0) {
            return ", ";
        }
        return "";
    }
}
