package step5.view;

import step5.common.MyException;
import step5.dto.CarNames;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String ASK_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    private static class InputViewHolder {
        private static InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.INSTANCE;
    }

    public CarNames readCarNames() {
        System.out.println(ASK_CARS_NAME);

        String inputNames = SCANNER.nextLine();

        validNamesOrThrow(inputNames);

        return Stream.of(inputNames.split(DELIMITER)).collect(Collectors.collectingAndThen(Collectors.toList(), CarNames::new));
    }

    public int readTrialCount() {
        System.out.println(ASK_TRIAL_COUNT);

        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(MyException.NUMBER_IS_INTEGER.getMessage());
        }
    }

    private void validNamesOrThrow(String inputNames) {
        emptyTextThrow(inputNames);

        String[] names = inputNames.split(DELIMITER);

        for (String name : names) {
            emptyTextThrow(name);
        }
    }

    private void emptyTextThrow(String text) {
        if (Objects.isNull(text) || text.trim().isEmpty()) {
            throw new IllegalArgumentException(MyException.NAME_IS_NOT_NULL.getMessage());
        }
    }

}
