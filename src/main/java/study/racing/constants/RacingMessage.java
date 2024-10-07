package study.racing.constants;

import java.util.Arrays;

public enum RacingMessage {
      CAR_COUNT("CAR_COUNT","자동차 대수는 몇 대 인가요?")
    , TRY_COUNT("TRY_COUNT", "시도할 회수는 몇 회 인가요?")
    , TRY_AGAIN("TRY_AGAIN", "다시 입력해주세요.");

    private final String code;
    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    RacingMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }

    public static RacingMessage find(String value) {
        return Arrays.stream(values())
                .filter(racingMessage -> racingMessage.getCode().equals(value))
                .findAny()
                .orElse(null);
    }


}
