package study.firstweek.secondstep;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private final Validator validator = new Validator();


    public int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        validator.validateNumberOfCars(carCount);
        return carCount;
    }

    public int getNumberOfTrials() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int trial = scanner.nextInt();
        validator.validateNumberOfTrials(trial);
        return trial;
    }

}
