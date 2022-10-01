package view;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import exception.NotValidNameException;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private int attempts;
    private String[] carNames;

    public String[] inputCarInfo() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.nextLine().split(",");
        nameValidation(carNames);


        System.out.println("시도할 회수는 몇 회 인가요?");
        attempts = scanner.nextInt();

        return carNames;
    }

    private void nameValidation(String[] carNames) {

        Optional<String> carName = Arrays
            .stream(carNames)
            .filter(it -> it.length()>5)
            .findAny();

        if (carName.isPresent()) {
            throw new NotValidNameException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public int getAttempts() {
        return attempts;
    }
}
