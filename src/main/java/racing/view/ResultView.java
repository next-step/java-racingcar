package racing.view;

import racing.Car;
import racing.Racing;

import java.util.List;
import java.util.stream.Collectors;

import static racing.view.ViewConstant.*;

/**
 * @author han
 */
public class ResultView {

    public void print(Racing racing) {
        System.out.println(RESULT_MESSAGE);

        for (int i = 0; i < racing.getAttempts(); i++) {
            List<Car> cars = racing.getLogs().get(i);
            printStep(cars);
        }
        printWinner(racing);
    }

    private void printStep(List<Car> cars) {
        for (Car car : cars) {
            String step = createResult(car);
            System.out.println(step);
        }
        System.out.println();
    }

    private String createResult(Car car) {
        int count = car.getStep();
        String name = car.getName();

        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");

        for (int i = 0; i < count; i++) {
            sb.append('-');
        }
        return sb.toString();
    }

    private void printWinner(Racing racing) {
        List<Car> winners = racing.getWinners();
        System.out.println(createWinner(winners));
    }

    private String createWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        String winnerNames = getWinnerNames(cars);
        sb.append(winnerNames + WINNER_MESSAGE_SUB_FIX);
        return sb.toString();
    }

    private String getWinnerNames(List<Car> cars) {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));
    }
}
