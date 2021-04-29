package ugemang.nextstep.domain.message;

public enum RacingGameMessageEnum {
    Q1("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)"),
    Q2("시도할회수는몇회인가요?"),
    E1("라운드는 음수가 될 수 없습니다"),
    E2("자동차 이름의 길이 조건이 맞지 않습니다."),
    E3("우승자가 존재하지 않습니다."),
    E4("자동차가 2대 이상 존재하지 않습니다."),
    E5("랩카운트는 라운드를 초과할 수 없습니다.");

    String message;

    RacingGameMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
