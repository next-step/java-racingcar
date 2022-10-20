package racing.msg;

public enum SystemMention {
    CAR_LIST("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분"),
    CNT_OF_TRY("시도할 회수는 몇 회 인가요?"),
    RESULT("실행 결과"),
    NULL_CHECK("빈값은 허용되지 않습니다"),
    NUMBER_CHECK("숫자만 입력해주세요"),
    POSITIVE_CHECK("1이상의 수를 입력해주세요"),
    SUFFIX_WINNER("가 최종 우승했습니다");

    private final String mention;

    SystemMention(String mention) {
        this.mention = mention;
    }

    public void printMention() {
        System.out.println(mention);
    }

    public void printMention(String prefix) {
        System.out.println(prefix + mention);
    }
}
