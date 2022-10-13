package racing;

public enum SystemMention {
    CNT_OF_CAR("자동차 대수는 몇 대 인가요?"),
    CNT_OF_TRY("시도할 회수는 몇 회 인가요?"),
    RESULT("실행 결과"),
    NULL_CHECK("값을 입력해주세요"),
    NUMBER_CHECK("숫자만 입력해주세요");

    private final String mention;

    SystemMention(String mention) {
        this.mention = mention;
    }

    public void printMention() {
        System.out.println(mention);
    }
}
