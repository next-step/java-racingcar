package step3.view;

import java.util.List;
import java.util.stream.Collectors;
import step3.util.ViewConstant;
import step3.domain.Car;
import step3.domain.Cars;

public class ResultView {

    public void printResult() {
        System.out.println(ViewConstant.RESULT);
    }

    public void printCars(Cars cars) {
        cars.getCars()
            .forEach(this::printTrack);
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        StringBuffer result = new StringBuffer();
        String winnerNames = getWinnerNames(winners);

        result.append(winnerNames);
        result.append(ViewConstant.WINNER);

        System.out.println(result);
    }

    private void printTrack(Car car) {
        StringBuffer track = new StringBuffer();
        track.append(car.getName());
        track.append(" : ");
        for (int position = 0; position < car.getPosition(); ++position) {
            track.append(ViewConstant.TRACK);
        }
        System.out.println(track);
    }

    private String getWinnerNames(List<Car> winners) {
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(ViewConstant.DELIMITER));
    }
}
