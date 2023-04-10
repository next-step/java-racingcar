package racingcar;

public class CarCollection {
    private Car[] carList;
    private int size;

    public CarCollection(int number) {
        this.carList = new Car[number];
        this.size = number;
    }

    public void tryMove() {
        for(int i=0; i<size; i++) {
            carList[i].tryMove();
        }
    }

    public int[] getPositionList() {
        int[] positionList = new int[size];
        for(int i=0; i<size; i++) {
            positionList[i] = carList[i].getPosition();
        }
        return positionList;
    }

    public int size() {
        return size;
    }
}
