package study.racing.view;

import study.racing.dto.RaceInput;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this(System.in);
    }

    public InputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public RaceInput race() {
        System.out.println("자동차 대수는 몇대인가요?");
        int numberOfCar = input();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfAttempt = input();

        return new RaceInput(numberOfCar, numberOfAttempt);
    }

    public int input() {
        while (true) {
            try {
                int number = scanner.nextInt();
                checkNumber(number);
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                System.out.println("------------------------------------");
                scanner.nextLine();
            } catch (RuntimeException e) {
                System.out.println("입력 값은 0보다 커야 합니다. 다시 입력해주세요.");
                System.out.println("------------------------------------");
            }
        }
    }

    private void checkNumber(int number) {
        if (number < 1) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.race();
    }

}
