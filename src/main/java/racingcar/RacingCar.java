package racingcar;

import racingcar.ui.InputView;

import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        int car = InputView.inputNumberOfCar();
        int num = InputView.inputNumberOfAttempts();
        System.out.println("car number: " + car + " attempts: " + num);
    }
}
