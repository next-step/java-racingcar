package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static String INPUT_NAMES_OF_CAR_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static String INPUT_TIMES_OF_RUN_MSG = "시도할 횟수는 몇회 인가요?";
    private static Scanner SCANNER = new Scanner(System.in);
    private static int MAX_LENGTH = 5;

    public static List<String> inputNamesOfCar() {
        List<String> nameList = new ArrayList<>();
        System.out.println(INPUT_NAMES_OF_CAR_MSG);

        String [] names = SCANNER.useDelimiter(",").nextLine().split(",");

        for (String name : names) {
            validateNameOfCar(name);
            nameList.add(name);
        }
        return nameList;
    }

    private static void validateNameOfCar(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
        }
    }

    public static int inputTimesOfRun() {
        System.out.println(INPUT_TIMES_OF_RUN_MSG);
        return SCANNER.useDelimiter("").nextInt();
    }

}