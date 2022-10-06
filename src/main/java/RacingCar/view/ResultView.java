package RacingCar.view;

import RacingCar.domain.Car;

import java.util.List;

public class ResultView {
    public void resultView() {
        System.out.println("실행 결과");
    }

    public static void roundView(List<Car> carList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            nameView(stringBuilder, car);
            positionView(car.getPosition(), stringBuilder);
        }
        System.out.println();
    }

    public void winnerView(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winners) {
            stringBuilder.append(car.getName());
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("가 최종 우승했습니다.");
        clearStringBuilder(stringBuilder);
    }

    private static void nameView(StringBuilder stringBuilder, Car car) {
        stringBuilder.append(car.getName());
        stringBuilder.append(" : ");
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
