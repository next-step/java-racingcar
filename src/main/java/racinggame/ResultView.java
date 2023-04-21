package racinggame;

import java.util.List;

public class ResultView {
    public static final String LOCATION_VIEW = "-";

    public void gameResultStart() {
        System.out.println("실행결과");
    }

    public void gameResultView(List<Car> cars) {
        for (Car car : cars) {
            showLocation(car);
        }
        System.out.println();
    }

    private void showLocation(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print(LOCATION_VIEW);
        }
        System.out.println();
    }

    public void gameWinnerView(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName());
            showComma(cars, i);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private void showComma(List<Car> cars, int i) {
        if (cars.size() > 1 && i < cars.size() - 1) {
            System.out.print(", ");
        }
    }

}
