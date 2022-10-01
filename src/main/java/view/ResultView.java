package view;

import java.util.List;

import domain.Car;
import domain.Cars;
import service.CarRace;

public class ResultView {

    private static final String DASH = "-";
    private static final String DELIMITER = " : ";

    public void printCarLocation(Cars cars, CarRace carRace, int attempts) {
        for (int i = 0; i < attempts; i++) {
            convertCarLocation(carRace, cars.getCarList());
            System.out.println();
        }
        System.out.println(winnerMessage(cars));
    }

    private void convertCarLocation(CarRace carRace, List<Car> carList) {
        List<Car> list = carRace.updateCurrentLocation(carList);
        for (Car car : list) {
            System.out.println(
                car.getCarName() + DELIMITER + convertLocationToDash(car.getCurrentLocation()));
        }
    }

    private String convertLocationToDash(int location) {
        return DASH.repeat(location);
    }

    private String winnerMessage(Cars cars) {
        List<String> winnerNames = cars.findWinner();
        String winners = String.join(", ", winnerNames);
        return winners + " 가 최종 우승했습니다!";
    }
}
