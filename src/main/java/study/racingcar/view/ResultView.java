package study.racingcar.view;

public class ResultView {
    private static final String RESPONSE_MESSAGE_SUFFIX_WINNERS = "가 최종 우승했습니다.";
    private static final String RESPONSE_MESSAGE_RESULT = "실행 결과";

    public static void printInitResult(){
        System.out.println();
        System.out.println(RESPONSE_MESSAGE_RESULT);
    }

    public static void printResult(String result){
        System.out.println(result);
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println(winners + RESPONSE_MESSAGE_SUFFIX_WINNERS);
    }
}
