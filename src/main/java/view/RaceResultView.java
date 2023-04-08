package view;

import domain.RaceResult;

public class RaceResultView implements ResultView {
    private final RaceResult raceResult;
    public RaceResultView(RaceResult raceResult) {
        this.raceResult = raceResult;
    }
    @Override
    public void print() {
        System.out.println("실행 결과");
        System.out.println(raceResult);
    }
}
