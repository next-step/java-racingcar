package racingcar;

public class CarCollection {
    private Car[] carList;
    private int size;

    public CarCollection(int number) {
        this.size = number;
        this.carList = new Car[number];
        for(int i=0; i<this.size; i++) {
            carList[i] = new Car();
        }
    }

    public void tryMove() {
        for(int i=0; i<this.size; i++) {
            this.carList[i].tryMove();
        }
    }

    public int[] getPositionList() {
        int[] positionList = new int[this.size];
        for(int i=0; i<this.size; i++) {
            positionList[i] = carList[i].getPosition();
        }
        return positionList;
    }

    public int size() {
        return this.size;
    }
}
