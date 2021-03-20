package RacingGame;

import java.util.Scanner;

public class InputView {
    private int numOfCar;
    private int numOfTry;

    public int inputNumOfCar(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        this.numOfCar = scanner.nextInt();
        return this.numOfCar;
    }

    public int inputNumOfTry(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        this.numOfTry = scanner.nextInt();
        return this.numOfTry;
    }

}
