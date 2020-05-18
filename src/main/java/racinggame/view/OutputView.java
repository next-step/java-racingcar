package racinggame.view;

import racinggame.domain.result.CarSnapshot;
import racinggame.domain.result.RacingGameResult;
import racinggame.domain.result.RacingGameSnapshot;

public class OutputView {
    private static final String TRACK_SIGNATURE = "-";
    private static final String WINNER_COMBINER = ",";

    public static void announceResult(RacingGameResult racingGameResult) {
        racingGameResult.findAllSnapshots()
                .forEach(OutputView::printTrackOf);

        System.out.printf("%s가 최종우승하였습니다.", String.join(WINNER_COMBINER, racingGameResult.findFinalWinners()));
    }

    private static void printTrackOf(RacingGameSnapshot racingGameSnapshot) {
        racingGameSnapshot.getCarSnapshots()
                .forEach(OutputView::printTrackOf);
        System.out.println();
    }

    private static void printTrackOf(CarSnapshot carSnapshot) {
        System.out.printf("%s : %s %n", carSnapshot.getName(), createTrack(carSnapshot.getLocation()));
    }

    private static String createTrack(int location) {
        StringBuilder tracks = new StringBuilder();

        for (int i = 0; i < location; i++) {
            tracks.append(TRACK_SIGNATURE);
        }

        return tracks.toString();
    }
}
