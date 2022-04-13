package CarRace;

import java.util.Scanner;

public class CarRace {
    int numberOfCars;
    int numberOfRaces;

    public CarRace(int numberOfCars, int numberOfRaces) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
    }

    public static void main(String[] args) {
        CarRace carRace = inputView();
    }


    private static CarRace inputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int inputNumberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int inputNumberOfRaces = scanner.nextInt();

        return new CarRace(inputNumberOfCars, inputNumberOfRaces);
    }
}
