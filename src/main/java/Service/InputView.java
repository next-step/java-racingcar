package Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import domain.Car;
import dto.CarDto;
import exception.NotNumberException;
import exception.NotPositiveNumberException;
import exception.NotValidNameException;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private String[] inputRaceCars;
    private int attempts;

    public void inputRaceCars() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String[] carList = scanner.nextLine().split(",");
        Car car = new Car();



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
        this.attempts = inputAttempt;
    }


    public String[] getInputRaceCars() {
        return inputRaceCars;
    }

    public int getAttempts() {
        return attempts;
    }
}
