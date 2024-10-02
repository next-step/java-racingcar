package racingcar.service;

import java.util.Scanner;

public class RacingCarService {
    private final Scanner scanner = new Scanner(System.in);

    public int EnterNumberOfCars() {
        return scanner.nextInt();
    }

    public int EnterNumberOfMoves() {
        return scanner.nextInt();
    }

}
