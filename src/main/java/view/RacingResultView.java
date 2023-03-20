package view;

public class RacingResultView {

    public static void printStartRacing() {
        System.out.println("");
        System.out.println("실행 결과");
    }

    public static void printResult(String carNames) {
        System.out.println("최종 우승자: " + carNames);
    }

    public static void printNameAndDistance(String name, int distance) {
        System.out.println(name + " : " + "-".repeat(distance));
    }

    public static void printNewLine() {
        System.out.println("");
    }
}
