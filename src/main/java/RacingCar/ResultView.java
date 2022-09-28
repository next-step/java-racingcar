package RacingCar;

import java.util.List;

public class ResultView {
    public void resultView() {
        System.out.println("실행 결과");
    }

    public static void roundView(List<Car> carList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            positionView(car.getPosition(), stringBuilder);
        }
        System.out.println();
    }

    private static void positionView(int position, StringBuilder stringBuilder) {
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        clearStringBuilder(stringBuilder);
    }

    private static void clearStringBuilder(StringBuilder stringBuilder) {
        System.out.println(stringBuilder.toString());
        stringBuilder.setLength(0);
    }
}
