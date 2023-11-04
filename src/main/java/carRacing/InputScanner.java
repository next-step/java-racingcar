package carRacing;


import java.util.Scanner;

public class InputScanner {

    private int carCount;
    private int trialCount;

    public void inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = scanner();
        carCount = scanner.nextInt();
    }


    public void inputTrialCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = scanner();
        trialCount = scanner.nextInt();
    }

    public int carCount() {
        return carCount;
    }

    public int trialCount() {
        return trialCount;
    }

    private static Scanner scanner() {
        return new Scanner(System.in);
    }

}
