package step3.service;

import java.util.Scanner;

import step3.domain.Car;
import step3.exception.NotNumberException;
import step3.exception.NotPositiveNumberException;

public class InputReview {

    private Car car;
    private static final Scanner scanner = new Scanner(System.in);

    public InputReview(Car car) {
        this.car = car;
    }

    public void inputCarNumber() {

        System.out.println("자동차 대수는 몇 대 인가요?");

        int inputNumber;
        try {
            inputNumber = scanner.nextInt();
        } catch (Exception e) {
            throw new NotNumberException("숫자만 입력하세요!");
        }
        if (inputNumber < 0)
            throw new NotPositiveNumberException("양수만 입력하세요");
        car.setCars(inputNumber);
    }

    public void inputAttemptNumber() {

        System.out.println("시도할 회수는 몇 회 인가요?");

        int inputAttempt;
        try {
            inputAttempt = scanner.nextInt();
        } catch (Exception e) {
            throw new NotNumberException("숫자만 입력하세요!");
        }
        if (inputAttempt < 0)
            throw new NotPositiveNumberException("양수만 입력하세요");
        car.setAttempts(inputAttempt);
    }
}
