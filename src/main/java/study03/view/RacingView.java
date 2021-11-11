package study03.view;

import study03.Track;

public class RacingView {

    public void racingStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingResult(Track track) {
        System.out.println(track.trackingAll());
        System.out.println();
    }
}
