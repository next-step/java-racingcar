package racinggame.view;

import racinggame.domain.CarSnapshot;
import racinggame.domain.RacingGameSnapshot;

import java.util.List;

public class OutputView {
    private static final String TRACK_SIGNATURE = "-";

    public static void announceResult(List<RacingGameSnapshot> racingGameSnapshots) {
        for (RacingGameSnapshot snapshot : racingGameSnapshots) {
            printTrackOf(snapshot);
            System.out.println();
        }
    }

    private static void printTrackOf(RacingGameSnapshot snapshot) {
        for (CarSnapshot carSnapshot : snapshot.getCarSnapshots()) {
            System.out.println(printTrackOf(carSnapshot));
        }
    }

    private static String printTrackOf(CarSnapshot carSnapshot) {
        StringBuilder track = new StringBuilder();

        for (int i = 0; i < carSnapshot.getLocation(); i++) {
            track.append(TRACK_SIGNATURE);
        }

        return track.toString();
    }
}
