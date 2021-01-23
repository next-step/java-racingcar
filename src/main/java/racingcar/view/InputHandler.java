package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;
    private static String inputCarName;
    private final int MAX_CAR_NAME_LENGTH = 5;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<String> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 , 기준으로 구분)");
        inputCarName = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(inputCarName.split(",")));
    }

    public String getCarNameStr() {
        return inputCarName;
    }

    public int inputLaps() {
        System.out.println("숫자 입력");
        return scanner.nextInt();
    }

    public Boolean checkCarName(ArrayList<String> carNames) {
        int invalidNames = (int) carNames.stream()
                .filter(name -> name.length() > MAX_CAR_NAME_LENGTH).count();
        return invalidNames == 0;
    }
}