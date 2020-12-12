package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

public class ViewResult {
    private static final String DELIMITER_SEMICOLON = " : ";
    private static final String MOVE_BAR = "-";

    public void view(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + DELIMITER_SEMICOLON);
            StringBuilder results = createResultMessage(car);
            System.out.println(results);
        }
        System.out.println();
    }

    private StringBuilder createResultMessage(Car car) {
        StringBuilder results = new StringBuilder("");
        for (int i = 0; i < car.getPosition(); i++) {
            results.append(MOVE_BAR);
        }
        return results;
    }

    public void showFirstLine() {
        System.out.println("실행 결과");
    }

    public void showWinnerCars(Cars winnerCars) {
        String names = winnerCars.getNames();
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
