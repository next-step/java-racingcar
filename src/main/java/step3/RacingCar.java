package step3;

import step3.view.InputView;

import java.util.Scanner;

public class RacingCar {

    public static final String RACE_SIGN = "-";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carNumber = InputView.setRacingCarNumber(scanner);
        int gameCount = InputView.setMotorRacingCount(scanner);
        System.out.println("carNumber : " + carNumber);
        System.out.println("gameCount : " + gameCount);
    }
}
