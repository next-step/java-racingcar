package step3.view;

import step3.domain.Car;
import step3.service.GameService;

import java.util.List;

public class ResultView {
    private final static String SET_OUTPUT_RESULT = "실행 결과\n";
    GameService gameService = new GameService();

    public void printStart() {
        System.out.println(SET_OUTPUT_RESULT);
    }

    public void printLocationView(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getLocationView());
        }
    }
}
