package racingcar.view;

public enum DisplayText {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_ROUND_NUMBER("시도할 회수는 몇 회 인가요?"),

    OUTPUT_RESULT_TITLE("실행 결과"),
    OUTPUT_RESULT_WINNER("가 최종 우승했습니다.");

    private String comment;

    DisplayText(String comment) {
        this.comment = comment;
    }

    public void printMessage() {
        System.out.println(this.comment);
    }

    public void printMessage(String prefix) {
        System.out.println(prefix + this.comment);
    }
}
