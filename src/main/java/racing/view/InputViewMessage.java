package racing.view;

public class InputViewMessage {
    public static final String SECOND_QUESTION = "시도할 회수는 몇 회 인가요?\n";
    public static final String INPUT_VALIDATION_ERROR = "오류:: 입력한 개수가 0보다 커야 합니다.\n\n";
    public static final String INPUT_FORMAT_VALIDATION_ERROR = "오류:: 숫자만 입력 가능합니다.\n\n";
    public static final String INPUT_CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    public static final String INPUT_CAR_NAME_LENGTH_VALIDATION_ERROR = "오류:: 자동차 이름은 5자를 초과할 수 없습니다.\n\n";

    private InputViewMessage() {}
}
