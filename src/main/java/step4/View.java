package step4;

import step4.checkor.ScoreCheckor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static step4.ViewManager.*;


public class View {

    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        String cars = inputMessageAboutCars();

        for (String carName : cars.split(",")) {
            drivers.add(new Driver(new Car(carName)));
        }

        int numOfTry = inputMessageAboutTry();

        outputMessageAboutMove(drivers, numOfTry);

        int winnerScore = new ScoreCheckor().check(drivers);
        outputMessageAboutWinner(drivers, winnerScore);
    }
}
