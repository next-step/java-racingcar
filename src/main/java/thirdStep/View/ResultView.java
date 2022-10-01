package thirdStep.View;

import thirdStep.logic.Race;

public class ResultView {

    public void printResult() {
        System.out.println("실행결과");
        for (int i = 0; i < InputView.getRaceCount(); i++) {
            printOneRace();
            System.out.println();
        }
    }

    public void printOneRace() {
        Race.startOneRace();
        int[] carStatus = Race.getCarStatus();
        for (int i = 0; i < carStatus.length; i++) {
            System.out.println(carStatus[i] * '-');
        }
    }
}
