package view;

import domain.RacingStadium;

public class OutputView {

    public void resultView(RacingStadium racingStadium) {
        for (int i = 0; i < racingStadium.getCars().length; i++) {
            System.out.print(racingStadium.getCars()[i].getName() + " : ");
            makeDash(racingStadium, i);
            System.out.println("");
        }
    }

    public void makeDash(RacingStadium racingStadium, int idx) {
        for (int j = 0; j < racingStadium.getCars()[idx].getPosition(); j++) {
            System.out.print("-");
        }
    }

    public void announceWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
