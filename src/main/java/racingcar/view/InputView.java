package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    private final Scanner scanner = new Scanner(System.in);

    public List<String> enterCarNames() {
        List<String > enteredCarNames = new ArrayList<>();
        boolean validCarNames = false;

        while (!validCarNames) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");

            enteredCarNames = new ArrayList<>(List.of(scanner.nextLine().split(",")));
            System.out.println(enteredCarNames);
            removeSpace(enteredCarNames);
            validCarNames = isValidCarNames(enteredCarNames);
        }

        return enteredCarNames;
    }

    public int enterNumberOfRace() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private boolean isValidCarNames(List<String> enteredCarNames) {
        return enteredCarNames.stream().allMatch(this::validateName);
    }

    private boolean validateName(String carName) {
        if (carName.isEmpty()) {
            System.out.println("이름은 비어있을 수 없습니다. 다시 입력해주세요");
            return false;
        }

        if (carName.length() > LIMIT_CAR_NAME_LENGTH) {
            System.out.println("이름은 5글자를 초과할 수 없습니다. 다시 입력해주세요");
            return false;
        }

        return true;
    }

    private void removeSpace(List<String> enteredCarNames) {
        for(int i = 0; i < enteredCarNames.size(); i++) {
            enteredCarNames.set(i, enteredCarNames.get(i).trim());
        }
    }

}
