package study.step4;

import java.util.List;

public class ResultView {

    private ResultView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }
    public static void outPut(Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Car> cars = track.getCars();
        for (Car car : cars) {
            addCarName(stringBuilder, car);
            changeCarMoveToString(stringBuilder, car);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void outPutWinner(Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Car> winners = track.getWinnerCars();
        int lastCarIndex = winners.size()-1;

        for (int i = 0; i <= lastCarIndex; i++) {
            stringBuilder.append(winners.get(i).getCarName());
            addComma(stringBuilder, lastCarIndex, i);
        }
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    private static void addComma(StringBuilder stringBuilder, int lastIndex, int count) {
        if (lastIndex == count) return;
        if (lastIndex > 0) {
            stringBuilder.append(", ");
        }
    }

    private static void changeCarMoveToString(StringBuilder stringBuilder, Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }
    }

    private static void addCarName(StringBuilder stringBuilder, Car car) {
        stringBuilder.append(car.getCarName());
        stringBuilder.append(" : ");
    }
}
