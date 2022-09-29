package Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import domain.Car;
import exception.NoWinnerException;
import repository.CarHistory;

public class ResultView {


    public void printCarLocation(CarRace carRace, CarHistory carHistory, int attempts) {

        for (int i = 0; i < attempts; i++) {
            List<Car> carHistories = carHistory.getSavedCarHistory();
            convertCarLocation(carRace, carHistory, carHistories);
            System.out.println();
        }
        String message = printWinner(carRace, carHistory, attempts);
        System.out.println(message);
    }

    private void convertCarLocation(CarRace carRace, CarHistory carHistory, List<Car> list1) {
        List<Car> list = carRace.updateCurrentLocation(carHistory, list1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " : " + list.get(i).getCurrentLocation());
        }
    }

    private String printWinner(CarRace carRace, CarHistory carHistory, int attempts) {

        String message = "";

        List<Car> winnerCars = carHistory.getSavedCarHistory()
            .stream()
            .filter(it -> it.getCurrentLocation() == attempts)
            .collect(Collectors.toList());

        if (winnerCars.size() == 0) {
            message = "우승자가 없습니다";
            return message;
        }

        List<String> winnerNames = winnerCars.stream().map(Car::getName).collect(Collectors.toList());
        String winners = String.join(", ", winnerNames);
        message = winners + " 가 최종 우승했습니다!";
        return message;
    }
}
