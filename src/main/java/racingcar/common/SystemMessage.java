package racingcar.common;

public enum SystemMessage {

    CAR_NAME_INPUT_INFO("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    RACING_TIME_INPUT_INFO("시도할 횟수는 몇 회인가요?"),
    CAR_NAME_LENGTH_LIMIT_ERROR("자동차 이름은 5글자를 넘을 수 없습니다."),
    CAR_NAME_DUPLICATE_ERROR("중복된 자동차 이름이 존재합니다."),
    FINAL_WINNERS_INFO("최종 우승자: ");

    SystemMessage(String message) {
    }
}
