package car_racing;

import java.util.Scanner;

public class UserInputProcessor {
    private static final Scanner scanner = new Scanner(System.in);

    public UserInput getUserInput() {
        int numOfCar = getNumOfCar();
        int numOfGame = getNumOfGame();
        return new UserInput(numOfCar, numOfGame);
    }

    private int getNumOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int getNumOfGame() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
