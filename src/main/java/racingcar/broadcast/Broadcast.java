package racingcar.broadcast;

public abstract class Broadcast {

    private static final String OPENING_MENT = "실행 결과";
    private static final String ENDING_MENT = "";

    abstract void print(String str);

    public void open() {
        print(OPENING_MENT);
    }

    public void comment(String content) {
        print(content);
    }

    public void end() {
        print(ENDING_MENT);
    }

}
