package step3.execute;

import step3.model.Car;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Step3_Execute {
    public static final int CONDITION_FOR_STEP_FORWARD = 4;
    public static final int RANDOM_BOUNDARY = 10;
    private List<Car> challengerList;
    private int trialCounts;
    private int numberOfCars;
    private Scanner scanner;
    private Random rand;

    public Step3_Execute() {
        initializeVariable();
        scanner = new Scanner(System.in);
        rand = new Random();
    }

    public void initializeVariable() {
        this.challengerList = new ArrayList<>();
        trialCounts = 0;
    }

    private void playGame() {
        for (int loop = 0; loop < this.numberOfCars; loop++) {
            randomize(loop);
            System.out.println(OutputView.getDashDistance(challengerList.get(loop).showDistance()));
        }
    }

    private void randomize(int loop) {
        if (rand.nextInt(RANDOM_BOUNDARY) >= CONDITION_FOR_STEP_FORWARD) {
            challengerList.get(loop).increseDistance();
        }
    }

    public void run() {
        // 입력부
        System.out.println(InputView.askQuestion("1"));
        numberOfCars = scanner.nextInt();
        System.out.println(InputView.askQuestion("2"));
        trialCounts = scanner.nextInt();

        for (int loop = 0; loop < numberOfCars; loop++) {
            challengerList.add(new Car());
        }

        //결과 출력
        System.out.println(OutputView.BANNER_STRING);
        for (int loop = 0; loop < trialCounts; loop++) {
            playGame();
            System.out.println();
        }
    }
}
