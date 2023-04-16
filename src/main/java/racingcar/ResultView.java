package racingcar;

public class ResultView {

    public void showCarsDistance(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.print("[" + i + "] : ");
            drawLines(cars[i]);
        }
        System.out.println();
    }

    private void drawLines(Car cars) {
        for (int i = 0; i < cars.getMoveCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

