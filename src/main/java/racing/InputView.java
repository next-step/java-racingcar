package racing;

import java.util.Scanner;

public class InputView {
    private static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TIMES = "시도할 회수는 몇 회 인가요?";

    private int cars;
    private int times;

    public InputView() {

    }

    public int getCars() {
        return cars;
    }

    public int getTimes() {
        return times;
    }

    public void inputView(Scanner scanner) {
        inputCars(scanner);
        inputTimes(scanner);
    }

    private void inputCars(Scanner scanner) {
        System.out.println(HOW_MANY_CARS);
        cars = scanner.nextInt();
    }

    private void inputTimes(Scanner scanner) {
        System.out.println(HOW_MANY_TIMES);
        times = scanner.nextInt();
    }
}
