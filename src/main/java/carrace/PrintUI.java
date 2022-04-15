package carrace;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintUI {
    private final Scanner scanner = new Scanner(System.in);

    public void inputView(CarRace carRace) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        carRace.setNumberOfCars(scanner.nextInt());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        carRace.setNumberOfRaces(scanner.nextInt());

        carRace.setRaceInfoBoards(new ArrayList<>());
    }

    public void resultView(CarRace carRace) {
        System.out.println("\n실행 결과");
        int i = 0;
        for (int result : carRace.getRaceInfoBoards()) {
            printRaceResultOfEachCar(result);
            i++;

            if (i == carRace.getNumberOfCars()) {
                System.out.println();
                i = 0;
            }
        }
    }

    public void printRaceResultOfEachCar(int result) {
        for (int i = 0; i < result; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
