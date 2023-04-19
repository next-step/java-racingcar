package car;

enum InputType {
    CAR_COUNT("자동차 대수는 몇 대 인가요?", "자동차 대수는 1 이상이어야 합니다."),
    TRY_COUNT("시도할 회수는 몇 회 인가요?", "시도 회수는 1 이상이어야 합니다.");

    private final String inputText;
    private final String rangeErrorMessage;

    InputType(String inputText, String rangeErrorMessage) {
        this.inputText = inputText;
        this.rangeErrorMessage = rangeErrorMessage;
    }

    public String getInputText() {
        return inputText;
    }

    public String getRangeErrorMessage() {
        return rangeErrorMessage;
    }
}
