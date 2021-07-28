package step4;

import step3.model.Car;

public class ResultView {
    private static String maxCarName;
    private static int maxCarPosition = 0;

    public void showCurrCarPosition(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showCurrCarName(String name) {
        System.out.print(name+": ");
    }

    public void findMaxPositionCarName(String carName, int carPosition) {
        if (carPosition > maxCarPosition) {
            maxCarName = carName;
            maxCarPosition = carPosition;
        } else if (carPosition == maxCarPosition) {
            maxCarName += ", "+carName;
        }
    }

    public void printFinalResult() {
        System.out.println(maxCarName+"가 최종 우승했습니다.");
    }
}
