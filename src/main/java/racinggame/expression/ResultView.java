package racinggame.expression;

/**
 * 1. "-" 상수
 * 1. 입력 크기 만큼 '-' 표기
 * 1. 한 라운드의 Car의 이동 거리 만큼 '-' 표기
 */
final public class ResultView {
    private static final char DASH = '-';

    public static void drawDash(int repeat) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < repeat; i++) {
            sb.append(DASH);
        }
        System.out.println(sb.toString());
    }

    public static void drawOneRoundResult() {

    }
}
