package view;

import domain.Cars;
import exception.NotValidNameException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private int attempts;

    public Cars inputCarInfo() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
        nameValidation(carNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        attempts = scanner.nextInt();

        return new Cars(carNames);
    }

    private void nameValidation(List<String> inputCarNames) {

        Optional<String> notValidCarName = inputCarNames
            .stream()
            .filter(it -> it.length() > 5)
            .findAny();

        if (notValidCarName.isPresent()) {
            throw new NotValidNameException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public int getAttempts() {
        return attempts;
    }
}
