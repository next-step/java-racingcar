package step3;

import java.util.Scanner;

public class RaceStartLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cars = new RaceInputForm(scanner).carsInput();
        int times = new RaceInputForm(scanner).raceTimeInput();

        Race.playing(cars, times);
    }
}
