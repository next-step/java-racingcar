package step3.view;

import step3.domain.Racecourse;
import step3.domain.RacingCar;
import step3.domain.Track;

import java.util.Optional;
import java.util.stream.Collectors;

public class ResultView {
    private static final String resultMessage = "실행 결과";
    private static final String carPositionIcon = "-";


    public static void printResultTitle() {
        System.out.println();
        System.out.println(resultMessage);
    }

    public static void printCarPosition(final Racecourse racecourse) {
        racecourse.tracks()
                .stream()
                .forEach(track -> System.out.println(writeCarPosition(track)));
        System.out.println();
    }

    public static void printTopRanking(final Racecourse racecourse) {
        final String topRankingRacingCars = racecourse.findTopRank().stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.printf("%s가 최종 우승했습니다.%n", topRankingRacingCars);
    }

    private static String writeCarPosition(final Track track) {
        return String.format("%s : ", track.carName()) + carPositionIcon.repeat(Math.max(0, track.carPosition()));
    }
}
