package step3.execute;

import step3.model.Car;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Step3_Execute {
    private List<Car> challengerList;
    private int trialCounts;
    private int numberOfCars;
    private Scanner scanner;

    public Step3_Execute() {
        initializeVariable();
        scanner = new Scanner(System.in);
    }

    public void initializeVariable() {
        this.challengerList = new ArrayList<>();
        trialCounts = 0;
    }

    private void playGame() {
        for (int loop = 0; loop < this.numberOfCars; loop++) {
            challengerList.get(loop).increaseDistanceWithRandom();
            System.out.println(OutputView.getDashDistance(challengerList.get(loop).showDistance()));
        }
    }

    public void run() {
        // 입력부
        System.out.println(InputView.askQuestion("1"));
        numberOfCars = scanner.nextInt();
        System.out.println(InputView.askQuestion("2"));
        trialCounts = scanner.nextInt();

        // Stream으로 변경
        challengerList = Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList());

        //결과 출력
        System.out.println(OutputView.BANNER_STRING);
        for (int loop = 0; loop < trialCounts; loop++) {
            playGame();
            System.out.println();
        }
    }
}
