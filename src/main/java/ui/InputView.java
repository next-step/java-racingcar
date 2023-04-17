package ui;

import car_racing.Car;
import dto.InputDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static InputDto getInputDto() {
        List<String> carNames = inputCarNames();
        checkCarNames(carNames);
        int trySize = inputTrySize();
        return new InputDto(carNames, trySize);
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String str = scanner.nextLine();
        List<String> carNames = Arrays.asList(split(str));
        return carNames;
    }

    private static void checkCarNames(List<String> carNames) {
        for (String carName : carNames) {
            checkCarName(carName);
        }
    }

    private static void checkCarName(String carName) {
        if (Car.isExceed5Characters(carName)) {
            throw new IllegalArgumentException("차이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private static int inputTrySize() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int trySize = scanner.nextInt();
        return trySize;
    }

    private static String[] split(String str) {
        return str.split(",");
    }


}
