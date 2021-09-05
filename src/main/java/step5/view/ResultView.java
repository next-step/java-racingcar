package step5.view;

import step5.domain.CarRacer;

import java.util.List;

public class ResultView {
    public void printCurrState(List<CarRacer> carRacers) {
        for (CarRacer carRacer: carRacers) {
            int position = carRacer.getCurrPosition();
            System.out.print(carRacer.getCarName()+":");
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printFinalResult(String maxCarName) {
        System.out.println(maxCarName+"가 최종 우승했습니다.");
    }
}
