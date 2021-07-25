package racingcar.view;

public class ResultView {

    private static final StringBuilder carStatusString = new StringBuilder();

    public static void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarPositionStatus(int position) {
        carStatusString.setLength(0);

        for (int i = 0; i < position; i++) {
            carStatusString.append("-");
        }

        System.out.println(carStatusString);
    }
}
