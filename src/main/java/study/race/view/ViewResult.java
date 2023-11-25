package study.race.view;

import study.race.model.Cars;
import study.race.model.Winners;


public class ViewResult {

    public void printRacingResult(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.getCarNameAt(i) + " : " + "-".repeat(cars.getCarDistanceAt(i)));
        }
        System.out.println();
    }

    public void printRacingWinners(Winners winners) {
        System.out.println(winners.getWinnersList() + " won in the racing.");
    }
}
