package racinggame.service;

import racinggame.domain.Validator;

public class InputService {

    public static final String SEPARATOR = ",";
    private static final String BLANK = "\\s+";
    private static final String EMPTY_STRING = "";


    public String[] parseCarNames(String inputCarNames) {
        String[] splitName = splitNameByComma(removeBlank(inputCarNames));
        Validator.checkNameIsBlank(splitName);

        return splitName;
    }

    private String removeBlank(String trial) {
        return trial.replaceAll(BLANK, EMPTY_STRING);
    }

    private String[] splitNameByComma(String inputCarNames) {
        return inputCarNames.split(SEPARATOR);
    }
}
