package racing.view;

import racing.model.Racing;

public class RacingView {

    private static final String moveText = "-";

    void printMoveLine(int carMove) {
        for (int i=0; i<carMove; i++) {
            System.out.print(moveText);
        }
        System.out.println("");
    }

    public void printCarMove(Racing racing) {
        racing.participants()
                .carList()
                .stream()
                .forEach(car -> printMoveLine(car.totalDistance()));
        System.out.println("");
    }

}
