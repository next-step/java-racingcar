package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class ResultView {
    private static final char HYPHEN = '-';

    public static void showRacingCarOutput(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(showMove(HYPHEN, car));
        }
        System.out.println();
    }

    public static String showMove(char hyphen, RacingCar racingCar) {
        StringBuffer track = new StringBuffer();
        for (int i = 0; i < racingCar.getPosition(); i++) {
            track.append(hyphen);
        }
        return track.toString();
    }
}
