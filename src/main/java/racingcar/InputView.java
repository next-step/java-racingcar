package racingcar;

import java.util.Scanner;

public class InputView {

    private int numberOfCar;
    private int chanceOfTry;

    Scanner scanner = new Scanner(System.in);

    public int numberOfCar(){
        System.out.println("자동차 대수는 몇 대 인가요?\n");
        return scanner.nextInt();
    }

    public int ChanceOfTry(){
        System.out.println("시도할 회수는 몇 회 인가요?\n");
        return scanner.nextInt();
    }

}
