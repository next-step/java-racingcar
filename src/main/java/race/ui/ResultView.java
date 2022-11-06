package race.ui;

public final class ResultView {

    public static final String RESULT_SENTENCE = "실행 결과";
    public static final String QUESTION_FOR_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String QUESTION_FOR_PLAY_COUNT = "시도할 횟수는 몇 회 인가요?";
    public static final String BAR = "-";

    private ResultView() {};

    public static void getFirstQuestion() {
        System.out.println(QUESTION_FOR_CAR_COUNT);
    }

    public static void getSecondQuestion() {
        System.out.println(QUESTION_FOR_PLAY_COUNT);
    }

    public static void getNewLine() {
        System.out.println();
    }

    public static void getResultSentence() {
        System.out.println(RESULT_SENTENCE);
    }

    public static void getPosition(int[] positions) {
        for (int position : positions) {
            System.out.println(BAR.repeat(position));
        }
    }
}
