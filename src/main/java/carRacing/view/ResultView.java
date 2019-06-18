package carRacing.view;

import carRacing.model.Car;
import carRacing.model.RacingCarGroup;
import com.google.common.base.Strings;

import java.util.StringJoiner;

public class ResultView {

    private final static String GRAPH_POSINT = "-";

    public static void printRacingMiddleResult(RacingCarGroup racingCarGroup) {
        for (Car car : racingCarGroup.getRacingCars()) {
            int position = car.getPosition();
            System.out.println(car.getName() + ":" + buildStringGraph(position));
        }
        System.out.println();
    }

    public static void printWinners(RacingCarGroup winners) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Car car : winners.getRacingCars()) {
            stringJoiner.add(car.getName());
        }
        System.out.println(stringJoiner.toString() + " 가 최종 우승했습니다. ");
    }

    private static String buildStringGraph(int position) {
        return Strings.repeat(GRAPH_POSINT, position);
    }
}
