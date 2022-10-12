package racing;

public enum SystemMention {
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
