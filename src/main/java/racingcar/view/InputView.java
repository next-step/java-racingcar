package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    private final Scanner scanner = new Scanner(System.in);

    public String[] enterCarNames() {
        String[] enteredCarNames = new String[0];
        boolean vaildCarName = false;

        while (!vaildCarName) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
            enteredCarNames = scanner.next().split(",");
            vaildCarName = checkCarNameLength(enteredCarNames);
        }
        
        return enteredCarNames;
    }

    public int enterNumberOfRace() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private boolean checkCarNameLength(String[] enteredCarNames) {
        for (String carName : enteredCarNames) {
            return carName.length() < LIMIT_CAR_NAME_LENGTH;
        }
        
        return true;
    }
    
}
