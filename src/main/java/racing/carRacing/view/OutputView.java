package racing.carRacing.view;

import racing.carRacing.Count;

public class OutputView {

    public static void printResultMention() {
        System.out.println("실행 결과");
    }

    public static void printCarStatus(String step) {
        System.out.println(step);
    }

    public static void printTotalStage(Count count) {
        System.out.println("총 회수 :" + count);
    }

    public static void printRemainStage(Count count) {
        System.out.println("==================");
        System.out.println("남은 회수 :" + count);
    }

}
