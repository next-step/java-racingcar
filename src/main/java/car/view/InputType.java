package car.view;

public enum InputType {
    CAR_COUNT("자동차 대수는 몇 대 인가요?", "자동차 대수는 1 이상이어야 합니다.", 1),
    TRY_COUNT("시도할 회수는 몇 회 인가요?", "시도 회수는 1 이상이어야 합니다.", 1),
    CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", "자동차 이름은 5자를 초과할 수 앖습니다.", 5);

    private final String inputText;
    private final String rangeErrorMessage;
    private final int standardValue;

    InputType(String inputText, String rangeErrorMessage, int standardValue) {
        this.inputText = inputText;
        this.rangeErrorMessage = rangeErrorMessage;
        this.standardValue = standardValue;
    }

    public String getInputText() {
        return inputText;
    }

    public String getRangeErrorMessage() {
        return rangeErrorMessage;
    }

    public int getStandardValue() {
        return standardValue;
    }
}
