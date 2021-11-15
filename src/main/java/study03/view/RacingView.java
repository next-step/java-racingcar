package study03.view;

import study03.racing.Track;

import java.util.List;

public class RacingView {

    public void racingStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingResult(Track track) {
        List<String> tracking = track.trackingAll();
        tracking.forEach(System.out::println);
        System.out.println();
    }
}
