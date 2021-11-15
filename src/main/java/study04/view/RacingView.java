package study04.view;

import study04.racing.RacingTrack;
import study04.racing.car.RacingCar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingView {

    private static final String MOVE_VIEW_CHARACTER = "-";

    public void racingStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingStatus(RacingTrack racingTrack, List<String> racingCarNames) {
        racingCarNames.stream()
                .map(racingTrack::getRacingCar)
                .forEach(this::printRacingStatus);

        System.out.println();
    }

    private void printRacingStatus(RacingCar racingCar) {
        System.out.println(String.format("%s : %s", racingCar.getName(), String.join("", Collections.nCopies(racingCar.currentMoveDistance(), MOVE_VIEW_CHARACTER))));
    }

    public void printRacingWinner(List<RacingCar> winnerRacingCar) {
        String winners = winnerRacingCar.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));

        System.out.println(String.format("%s가 최종 우승했습니다.", winners));
    }
}
