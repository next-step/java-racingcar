package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    private final Scanner scanner = new Scanner(System.in);

    public String[] enterCarNames() {
        String[] enteredCarNames = new String[0];
        boolean validCarName = false;

        while (!validCarName) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");

            enteredCarNames = scanner.nextLine().split(",");
            removeSpaces(enteredCarNames);
            validCarName = isValidCarName(enteredCarNames);
        }

        return enteredCarNames;
    }

    public int enterNumberOfRace() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private boolean isValidCarName(String[] enteredCarNames) {
        for (String carName : enteredCarNames) {
            if (carName.isEmpty()) {
                System.out.println("이름은 비어있을 수 없습니다. 다시 입력해주세요");
                return false;
            }

            if(carName.length() > LIMIT_CAR_NAME_LENGTH) {
                System.out.println("이름은 5글자를 초과할 수 없습니다. 다시 입력해주세요");
                return false;
            }
        }

        return true;
    }

    private void removeSpaces(String[] enteredCarNames) {
        for (int i = 0; i < enteredCarNames.length; i++) {
            enteredCarNames[i] = enteredCarNames[i].trim();
        }
    }

}
