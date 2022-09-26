package game;

import java.util.Scanner;

public class RacingGame {

    private Integer numberOfCar;
    public void inputNumberOfCar() {
        try(Scanner sc = new Scanner(System.in)) {
            this.numberOfCar = sc.nextInt();
        }
    }

    public int cars() {
        return numberOfCar;
    }
}
