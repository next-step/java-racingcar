package racing;

import java.util.Scanner;

public class Data {

    private final int cars;
    private final int trials;

    public Data(int cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public static Data userInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int trials = scanner.nextInt();

        return new Data(cars, trials);
    }

    public int carData() {
        return cars;
    }

    public int trialData() {
        return trials;
    }
}
