package racing;

import java.util.List;

class OutputView {
    private static final String MOVE_POINT = "-";
    private static final int FIRST_WINNER = 0;

    private OutputView() {
        throw new AssertionError();
    }

    static void printStartLine() {
        System.out.println("실행 결과");
    }

    static void renderProcess(Cars cars) {
        for (Car car : cars.getCars()) {
            renderProcess(car);
        }
        System.out.println(" ");
    }

    private static void renderProcess(Car car) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(car.getName()).append(" ").append(":").append(" ");
//        for (int i = 0; i < car.getPosition(); i++) {
//            stringBuilder.append(MOVE_POINT);
//        }
//        System.out.println(stringBuilder);
    }

    static void renderResult(List<Car> cars) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < cars.size(); i++) {
//            writeWinnerList(cars.get(i), stringBuilder, i);
//        }
//        stringBuilder.append("가 최종 우승했습니다.");
//        System.out.println(stringBuilder);
    }

    private static void writeWinnerList(Car car, StringBuilder stringBuilder, int winnerOrder) {
        if (FIRST_WINNER == winnerOrder) {
            stringBuilder.append(car.getName());
            return;
        }
        stringBuilder.append(", ").append(car.getName());
    }

    static void renderResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            writeWinnerList(cars.get(i), stringBuilder, i);
        }
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    private static void writeWinnerList(Car car, StringBuilder stringBuilder, int winnerOrder) {
        if (FIRST_WINNER == winnerOrder) {
            stringBuilder.append(car.getName());
            return;
        }
        stringBuilder.append(", ").append(car.getName());
    }
}
