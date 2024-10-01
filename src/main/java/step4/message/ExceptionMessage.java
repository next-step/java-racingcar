package step4.message;

public enum ExceptionMessage {

    MINIMUN_CAR_EXCEPTION("최소 2대 이상의 차가 있어야 레이싱이 가능합니다."),
    MINIMUN_CAR_NAME_EXCEPTION("자동차 이름은 5자를 초과하면 안됩니다."),
    GAME_NOT_START("게임이 아직 시작되지 않았습니다."),
    GAME_ALREADY_START("게임이 이미 시작되었습니다."),
    MINIMUN_ATTEMPT_EXCEPTION("최소 1회 이상의 시도 회수가 입력되야 레이싱이 가능합니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }
}
