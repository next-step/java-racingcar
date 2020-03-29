package step4.racing.domain;

public class RacingInfo {

    private String inputName;
    private String[] names;
    private int count;


    private static final String SEPERATOR = ",";
    private static final String INPUT_NAME_INVALID_MESSAGE = "사용자 이름을 입력해주세요";
    private static final String NULL_NAME_INVALID_MESSAGE = "사용자 이름이 빈값일수는 없습니다.";
    private static final String INPUT_COUNT_INVALID_MESSAGE = "진행횟수는 1이상 입력하세요.";

    public RacingInfo(String inputName, int count) {
        inputNameValidator(inputName);
        countValidator(count);
        this.inputName = inputName;
        this.count = count;
        this.names = splitName(inputName);
    }

    private void inputNameValidator(String inputName) {
        if (isNullOrEmpty(inputName)) {
            throw new IllegalArgumentException(INPUT_NAME_INVALID_MESSAGE);
        }
    }

    private void countValidator(int inputCount) {
        if (inputCount < 1) {
            throw new IllegalArgumentException(INPUT_COUNT_INVALID_MESSAGE);
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().length() == 0;
    }

    private void splitNameValidator(String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException(NULL_NAME_INVALID_MESSAGE);
        }
    }

    private String[] splitName(String inputName) {
        String[] names = inputName.split(SEPERATOR);

        for (String name : names) {
            splitNameValidator(name);
        }

        return inputName.split(SEPERATOR);
    }

    public String getInputName() {
        return inputName;
    }

    public int getCount() {
        return count;
    }

    public String[] getNames() {
        return names;
    }
}
