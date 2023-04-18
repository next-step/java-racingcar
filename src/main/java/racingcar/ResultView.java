package racingcar;

import java.util.List;

public class ResultView {
    private final Screen screen = new Screen();

    public void result(List<Car> carList) {
        screen.print("실행 결과");
        carList.forEach(car -> screen.print(convert(car.distanceDriven())));
    }

    private String convert(int distanceDriven) {
        String result = "";
        for (int i = 0; i < distanceDriven; i++) {
            result += "-";
        }
        return result;
    }

}
