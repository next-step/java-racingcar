package step3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private int carCount;
    private int roundCount;
    private String[] carNames;

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public String[] getCarNames() {
        return carNames;
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

    public void setCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("null 또는 빈값을 입력할 수 없습니다");
        }
        this.carNames = carNames.split(",");
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

    public void setNamesAndCount() {
        try (Scanner scanner = new Scanner(System.in)) {
            printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
            setCarNames(scanner.nextLine());

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
