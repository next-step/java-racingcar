package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputView {
    private Scanner scanner = null;

    private Integer times = null;
    private Integer cars = null;

    public RacingInputView() {
        this.scanner = new Scanner(System.in);
    }

    public void render() {
        System.out.println("시도할 회수는 몇 회 인가요?\n");
        inputCars();
        System.out.println("자동차 대수는 몇 대 인가요?\n");
        inputTimes();
    }

    private void inputTimes() {
        try {
            times = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("That's not a number!");
        }
    }

    private void inputCars() {
        try {
            cars = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("That's not a number!");
        }
    }

    public Integer getTimes() {
        return times;
    }

    public Integer getCars() {
        return cars;
    }

    public boolean isDone() {
        if (cars == null) {
            return false;
        }

        if (times == null) {
            return false;
        }

        return true;
    }

}
