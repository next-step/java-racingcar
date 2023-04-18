package study.step5.view;

import study.step5.domain.model.*;
import study.step5.utils.CommonUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
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

        String winnerNames = winners.stream()
                .map(n -> String.valueOf(n.getName()))
                .collect(Collectors.joining(", "));

        stringBuilder.append(winnerNames)
                .append("가 최종 우승했습니다.");

        System.out.println(stringBuilder);
    }

    private static String changeCarMoveToString(Car car) {
        String move = CommonUtil.POSITION_CHARTER;
        move = move.repeat(car.getPosition());
        return move;
    }
}
