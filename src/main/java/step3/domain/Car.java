package step3.domain;

public class Car {

    private CarHistoryList history = new CarHistoryList();

    public void operate(int number) {
        CarOperation carOperation = CarOperation.from(number);
        int movedPosition = history.getLastPosition() + carOperation.getValue();
        history.add(carOperation, movedPosition);
    }

    public int getPosition(int round) {
        return history.getPosition(round);

    }

}