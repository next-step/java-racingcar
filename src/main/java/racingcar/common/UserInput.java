package racingcar.common;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import racingcar.common.exception.InputValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {


    private static final String DELIMITER = ",";
    private List<String> splitUserInput;
    private String carNameInput;
    private int racingTryCounter;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public UserInput() {
        while (parsingCarName())
            ;
        while (parsingRacingTry())
            ;
    }

    private boolean parsingCarName() {
        try {
            log.write("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            log.flush();
            this.carNameInput = bufferedReader.readLine();
            splitUserInput = splitStr(carNameInput);
            validateLengthLimit(splitUserInput);
            validateDuplicateCar(splitUserInput);
        } catch (IOException | InputValidationException exception) {
            exception.printStackTrace();
            return true;
        }
        return false;
    }

    private boolean parsingRacingTry() {
        try {
            log.write("시도할 횟수는 몇 회인가요?");
            log.flush();
            this.racingTryCounter = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException | InputValidationException exception) {
            exception.printStackTrace();
            return true;
        }
        return false;
    }

    private void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream()
            .allMatch(input -> input.length() <= 5 && input.length() >= 1);

        if (!match) {
            throw new InputValidationException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }

    }

    private void validateDuplicateCar(final List<String> splitUserInput) {
        int size = splitUserInput.stream().distinct().collect(Collectors.toList()).size();

        if (size != splitUserInput.size()) {
            throw new InputValidationException("중복된 자동차 이름이 존재합니다.");
        }
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

}
