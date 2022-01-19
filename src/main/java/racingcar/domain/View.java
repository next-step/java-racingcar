package racingcar.domain;

public class View {

    private View() {}

    public static void printDistance(Car car) {
        System.out.println(car.toString());
    }

    public static void printWhoIsWinner(String winners) {
        System.out.print("최종 우승자 : " + winners);
    }

    public static void printTurnResult() {
        System.out.println("실행 결과");
    }
}
