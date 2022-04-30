package racing;

public class OutputView {
    private static final String MOVE_POINT = "-";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printStartLine() {
        System.out.println("실행 결과");
    }

    public static void render(Cars cars) {
        for (Car car : cars.getCars()) {
            render(car.getPosition());
        }
        System.out.println(" ");
    }

    private static void render(int move) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < move; i++) {
            stringBuilder.append(MOVE_POINT);
        }
        System.out.println(stringBuilder);
    }
}
