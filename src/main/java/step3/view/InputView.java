package step3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private int carCount;
    private int roundCount;

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setCarCount(int carCount) {
        if (carCount < 1) {
            throw new IllegalArgumentException("1이상의 숫자를 입력하세요");
        }
        this.carCount = carCount;
    }

    public void setRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("1이상의 숫자를 입력하세요");
        }
        this.roundCount = roundCount;
    }

    public void setCount() {
        try (Scanner scanner = new Scanner(System.in)) {
            printMessage("자동차 대수는 몇 대 인가요?");
            setCarCount(scanner.nextInt());

            printMessage("시도할 횟수는 몇 회 인가요?");
            setRoundCount(scanner.nextInt());
        } catch (InputMismatchException e) {
            printMessage("숫자를 입력하세요");
            throw e;
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            throw e;
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
