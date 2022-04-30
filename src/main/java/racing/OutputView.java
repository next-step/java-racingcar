package racing;

import java.util.ArrayList;

public class OutputView {
    private static final String MOVE_POINT = "-";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printStartLine() {
        System.out.println("실행 결과");
    }

    public static void render(int move) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < move; i++) {
            stringBuilder.append(MOVE_POINT);
        }
        System.out.println(stringBuilder);
    }

    public static void render(ArrayList<Car> cars) {
        for (Car car : cars) {
            render(car.position);
        }
        System.out.println(" ");
    }
}
