package study.racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int initCar(){
        return scanner.nextInt();
    }

    public int initRound(){
        return scanner.nextInt();
    }

}
