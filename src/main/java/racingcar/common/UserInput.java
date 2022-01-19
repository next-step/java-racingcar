package racingcar.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UserInput {

    private static final String DELIMITER = ",";
    private List<String> splitUserInput;
    private String userInput;

    public UserInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.userInput = bufferedReader.readLine();
            splitUserInput = splitStr(userInput);
            validateLengthLimit(splitUserInput);
            validateDuplicateCar(splitUserInput);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
