package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> carNames;
    private static String inputCarName;
    private static int MAX_CAR_NAME_LENGTH = 5;

    public ArrayList<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 , 기준으로 구분)");

        inputCarName = scanner.nextLine();
        carNames = new ArrayList<>(Arrays.asList(inputCarName.split(",")));

        return carNames;
    }

    public String getCarNameStr() {
        return inputCarName;
    }

    public static int inputLaps() {
        System.out.println("숫자 입력");
        return scanner.nextInt();
    }

    public Boolean carNameChecker(ArrayList<String> carNames) {
        int invalidNames = carNames.stream()
                .filter(name -> name.length() > MAX_CAR_NAME_LENGTH)
                .collect(Collectors.toList()).size();

        return invalidNames == 0;
    }
}
