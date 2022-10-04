package view;

import domain.Cars;
import java.util.List;
import service.CarRace;

public class ResultView {

    public void printCarLocation(Cars cars, CarRace carRace, int attempts) {
        for (int i = 0; i < attempts; i++) {
            carRace.printCarLocationPerAttempt(cars.getCars());
            System.out.println();
        }
        System.out.println(winnerMessage(cars));
    }

    private String winnerMessage(Cars cars) {
        List<String> winnerNames = cars.findWinner();
        String winners = String.join(", ", winnerNames);
        return winners + " 가 최종 우승했습니다!";
    }
}
