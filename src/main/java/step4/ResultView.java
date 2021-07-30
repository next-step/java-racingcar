package step4;

import step3.model.Car;

public class ResultView {


    public void showCurrCarPosition(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showCurrCarName(String name) {
        System.out.print(name+": ");
    }



    public void printFinalResult(String maxCarName) {
        System.out.println(maxCarName+"가 최종 우승했습니다.");
    }
}
