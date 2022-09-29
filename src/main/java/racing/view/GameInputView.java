package racing.view;

import util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static util.NumberUtils.notPositive;


public class GameInput {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String CAR_NAME_SEPARATOR = ",";
    private final static int CAR_NAME_MAX_LENGTH = 5;
    private int count = 0;
    private String carNames = "";

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차들의 이름을 입력하세요. (조건: 차량명 구분 기준은 쉼표, 5자 이하의 이름만 가능)");
        inputString();
        return Arrays.asList(carNames.split(CAR_NAME_SEPARATOR));
    }

    public int inputMoveCount() {
        System.out.println("앞으로 몇 번을 이동하시겠습니까?");
        inputCount();
        return count;
    }

    private void inputString() {
        carNames = SCANNER.nextLine();
        if (StringUtils.isNullOrEmpty(carNames) || !carNames.contains(CAR_NAME_SEPARATOR) || checkLengthOfCarNames()) {
            System.out.println("자동차 이름의 형식이 잘못되었습니다.");
            carNames = SCANNER.nextLine();
        }
    }

    private void inputCount() {
        count = SCANNER.nextInt();
        while (notPositive(count)) {
            System.out.println("양수만 입력 가능합니다.");
            count = SCANNER.nextInt();
        }
    }

    private boolean checkLengthOfCarNames() {
        return Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH);
    }
}