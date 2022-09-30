package racinggame;

public class OutputView {

    private OutputView() {}

    public static void printResult(RacingGameResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getContent());
    }

}
