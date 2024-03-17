package racingcar;

public class OutputView {
    public void printCarPosition(int carPosition) {
        for (int i = 0; i <= carPosition; i++) {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public void printCarGroupPosition(CarGroup carGroup) {
        for (int carIndex = 0; carIndex < carGroup.carGroupLength(); carIndex++) {
            printCarPosition(carGroup.position(carIndex));
        }
        System.out.println("==========");
    }
}
