package Service;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;
import repository.CarHistory;

public class ResultView {

    private static final String DASH = "-";
    private static final String DELIMITER = " : ";


    public void printCarLocation(CarRace carRace, CarHistory carHistory, int attempts) {
        for (int i = 0; i < attempts; i++) {
            List<Car> carHistories = carHistory.getSavedCarHistory();
            convertCarLocation(carRace, carHistory, carHistories);
            System.out.println();
        }
        String message = printWinner(carHistory, attempts);
        System.out.println(message);
    }

    private void convertCarLocation(CarRace carRace, CarHistory carHistory, List<Car> list1) {
        List<Car> list = carRace.updateCurrentLocation(carHistory, list1);
        for (Car car : list) {
            System.out.println(
                car.getCarName() + DELIMITER + convertLocationToDash(car.getCurrentLocation()));
        }
    }

    private String convertLocationToDash(int location) {
        StringBuilder convertedToDash = new StringBuilder();
        for (int i = 0; i < location; i++) {
            convertedToDash.append(DASH);
        }
        return convertedToDash.toString();
    }

    private String printWinner(CarHistory carHistory, int attempts) {
        String message = "";
        List<Car> winnerCars = carHistory.getSavedCarHistory()
            .stream()
            .filter(it -> it.getCurrentLocation() == attempts)
            .collect(Collectors.toList());

        if (winnerCars.size() == 0) {
            message = "우승자가 없습니다";
            return message;
        }
        List<String> winnerNames = winnerCars.stream().map(Car::getCarName)
            .collect(Collectors.toList());
        String winners = String.join(", ", winnerNames);
        message = winners + " 가 최종 우승했습니다!";
        return message;
    }

    private String printWinner
}
