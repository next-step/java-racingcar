package step3.view;

import step3.domain.Racecourse;
import step3.domain.Track;

public class ResultView {
    private static final String resultMessage = "실행 결과";
    private static final String carPositionIcon = "-";

    public static void printResultTitle() {
        System.out.println();
        System.out.println(resultMessage);
    }

    public static void printCarPosition(Racecourse racecourse) {
        racecourse.tracks()
                .stream()
                .map(Track::carPosition)
                .forEach(carPosition -> System.out.println(writeCarPosition(carPosition)));
        System.out.println();
    }

    private  static String writeCarPosition(int carPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carPositionIcon.repeat(Math.max(0, carPosition)));
        return stringBuilder.toString();
    }
}
