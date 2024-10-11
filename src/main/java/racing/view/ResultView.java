package racing.view;

import racing.entity.Car;

import java.util.List;

public class ResultView {
    public void printResult(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result.append(buildCarResult(car)).append("\n"));
        System.out.println(result.toString());
    }

    private String buildCarResult(Car car) {
        return car.getName() + ": " + carPosition(car.getPosition());
    }

    private String carPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}

