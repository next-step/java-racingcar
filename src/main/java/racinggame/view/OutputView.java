package racinggame.view;

import racinggame.domain.CarSnapShot;
import racinggame.domain.RacingGameSnapshot;

import java.util.List;

public class OutputView {
    private static final String TRACK_SIGNATURE = "-";

    public static void announceResult(List<RacingGameSnapshot> racingGameSnapshots) {
        for (RacingGameSnapshot snapshot : racingGameSnapshots) {
            announceResult(snapshot);
            System.out.println();
        }
    }

    private static void announceResult(RacingGameSnapshot snapshot) {
        for (CarSnapShot carSnapshot : snapshot.getCarSnapShots()) {
            System.out.println(announceResult(carSnapshot));
        }
    }

    private static String announceResult(CarSnapShot carSnapshot) {
        StringBuilder track = new StringBuilder();

        for (int i = 0; i < carSnapshot.getLocation(); i++) {
            track.append(TRACK_SIGNATURE);
        }

        return track.toString();
    }
}
