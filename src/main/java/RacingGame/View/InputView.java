package RacingGame.View;

import RacingGame.Domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int InputCarNumber() {
        System.out.println("How many cars?");
        int carNum = scanner.nextInt();
        return carNum;
    }

    public int InputTrialNumber() {
        System.out.println("How many trials?");
        int trialNum = scanner.nextInt();
        return trialNum;
    }
}
