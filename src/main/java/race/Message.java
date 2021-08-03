package race;

public class Message {

    private static final String messageCarCount = "자동차 대수는 몇 대 인가요?";

    private static final String messageGameCount = "시도할 회수는 몇 회 인가요?";

    protected static void askCarCount() {
        System.out.println(messageCarCount);
    }

    protected static void askGameCount() {
        System.out.println(messageGameCount);
    }

}
