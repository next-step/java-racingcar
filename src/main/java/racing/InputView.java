package racing;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        Race race = createRace();
        race.play();
        showResult(race);
    }

    private static void showResult(Race race) {
        ArrayList<ArrayList<String>> result = race.result();
        System.out.println("실행 결과");
        for (ArrayList<String> carsLocation : result) {
            showCarLocations(carsLocation);
            System.out.println();
        }
    }

    private static void showCarLocations(ArrayList<String> carsLocation) {
        for (String location : carsLocation) {
            System.out.println(location);
        }
    }

    private static Race createRace() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner carScanner = new Scanner(System.in);
        int numberOfCars = carScanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner playScanner = new Scanner(System.in);
        int numberOfPlays = playScanner.nextInt();

        return new Race(numberOfCars, numberOfPlays);
    }
}
