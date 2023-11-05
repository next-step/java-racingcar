package step3;

import java.util.Scanner;

public class PlayRacingCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cars = Cars.carsInput(scanner);
        int times = Race.raceTimeInput(scanner);

        Race.playing(cars, times);
    }
}
