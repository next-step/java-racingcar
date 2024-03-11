package racingcar.ui;

public class ResultView {

    private ResultView() {

    }

    public static void printAnswerHowManyCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printAnswerHowManyTrys() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    public static void printExecuteResultString() {
        System.out.println("실행 결과");
    }

    public static void write(String str) {
        System.out.println(str);
    }

}
