package racing.view;

import racing.domain.Car;
import racing.domain.RacingHistory;
import racing.domain.Winner;

import java.util.List;
import java.util.stream.Collectors;

import static racing.constant.ViewConstant.RESULT_MESSAGE;
import static racing.constant.ViewConstant.WINNER_MESSAGE_SUB_FIX;

/**
 * @author han
 */
public class ResultView {

    public void print(Winner winner) {
        System.out.println(RESULT_MESSAGE);
        printHistory(winner);
        printWinner(winner);
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

    private void printWinner(Winner winner) {
        List<Car> winners = winner.getWinners();
        System.out.println(createWinner(winners));
    }

    private String createWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        String winnerNames = getWinnerNames(cars);
        sb.append(winnerNames);
        sb.append(WINNER_MESSAGE_SUB_FIX);
        return sb.toString();
    }

    private String getWinnerNames(List<Car> cars) {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));
    }

    private void printHistory(Winner winner) {
        RacingHistory racingHistory = winner.getRacingHistory();

        while (racingHistory.hasData()) {
            printStep(racingHistory.poll());
        }
    }
}
