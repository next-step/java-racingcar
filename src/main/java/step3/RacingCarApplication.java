package step3;

import step3.domain.Racecourse;
import step3.domain.RacingCar;
import step3.domain.Track;
import step3.util.RacingCreateHelper;
import step3.view.InputView;

import java.util.List;
import java.util.Scanner;

import static step3.util.RacingCreateHelper.createRacingCars;
import static step3.util.RacingCreateHelper.createTracks;

public class RacingCarApplication {
    private static final Scanner scanner = new Scanner(System.in);

    private static void run() {
        final int carNumbers = InputView.inputCarNumbers(scanner);
        final int tryNumbers = InputView.inputTryNumbers(scanner);

        final List<RacingCar> racingCars = createRacingCars(carNumbers);
        final List<Track> tracks = createTracks(carNumbers);
        final Racecourse racecourse = new Racecourse();

        for (int i = 0; i < tracks.size(); i++) {
            tracks.get(i).entrance(racingCars.get(i));
        }

        for (Track track : tracks) {
            racecourse.addTrack(track);
        }

        for (int i = 0; i < tryNumbers; i++) {
            racingCars.forEach(RacingCar::steeringToForward);
        }
    }

    public static void main(String[] args) {
        RacingCarApplication.run();
    }
}
