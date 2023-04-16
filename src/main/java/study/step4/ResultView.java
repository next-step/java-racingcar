package study.step4;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String POSITION_CHARTER = "-";

    private ResultView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static void outPut(Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Car> cars = track.getCars();
        for (Car car : cars) {
            stringBuilder.append(String.format("%s : %s%n", car.getName(), changeCarMoveToString(car)));
        }
        System.out.println(stringBuilder);
    }

    public static void outPutWinner(Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Car> winners = track.getWinnerCars();

        String victoryMessage = winners.stream().map(n -> String.valueOf(n.getName()))
                .collect(Collectors.joining(", "));
        stringBuilder.append(victoryMessage).append("가 최종 우승했습니다.");

        System.out.println(stringBuilder);
    }

    private static StringBuilder changeCarMoveToString(Car car) {
        StringBuilder move = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            move.append(POSITION_CHARTER);
        }
        return move;
    }
}
