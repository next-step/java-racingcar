package view;

import domain.CarName;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PLAY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String SPLIT_COMMA = ",";

    public List<CarName> getSplitCarName() {
        System.out.println(INPUT_CAR_NAME);
        String carName = scanner.nextLine();
        return Arrays.stream(carName.split(SPLIT_COMMA))
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    private int getPositiveIntValue() {
        int intValue = scanner.nextInt();
        if (intValue < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력하세요.");
        }

        return intValue;
    }

    public int getPlayCount() {
        System.out.println(PLAY_COUNT);
        return getPositiveIntValue();
    }
}
