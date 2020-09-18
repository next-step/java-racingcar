package racing.message;

public enum ViewMessage {

    START_MESSAGE_INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    START_MESSAGE_INPUT_TRY_COUNT("시도할 회수는 몇 회 인가요?"),
    START_RESULT_VIEW("실행 결과"),
    WINNER_NOTICE("가 최종 우승했습니다.");


    String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
