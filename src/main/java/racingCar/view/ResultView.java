package racingCar.view;

import racingCar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printCars(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder position = new StringBuilder();
            for(int i=0; i < car.getPosition(); i++) {
                position.append("-");
            }
            System.out.println(car.getName()+" : "+position);
        });
        System.out.println("");
    }

    public static String showWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> {
            if (car.getWinnerFlag()) {
                winners.add(car.getName());
            }
        });
        String output = "최종 우승자 : "+winners;
        return output;
    }
}
