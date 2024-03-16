package racingcar;

public class OutputView {
    private CarArray carArray;

    public OutputView(CarArray carArray) {
        this.carArray = carArray;
    }

    public void printCarPosition(int carPosition) {
        for (int i = 0; i <= carPosition; i++)
        {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public void printCarArrayPosition() {
        for (int carIndex = 0; carIndex < carArray.mNumOfCar; carIndex++)
        {
            printCarPosition(carArray.position(carIndex));
        }
        System.out.println("==========");
    }
}
