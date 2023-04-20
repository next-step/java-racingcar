package racing;

public class Winner {
    private String name;
    private int maxMoveStatus = 0;
    private final Cars cars;

    public Winner(Cars cars){
        this.cars = cars;
        findWinner();
    }

    private void findWinner() {
        for (int carIndex = 0; carIndex < cars.count(); carIndex++) {
            checkWinner(carIndex);
        }
    }

    private void checkWinner(int carIndex) {
        if(cars.isWinner(carIndex,maxMoveStatus)){
            replaceWinner(carIndex);
        }
    }

    private void replaceWinner(int carIndex) {
        if (cars.isSharedWinner(carIndex,maxMoveStatus)) {
            this.name = this.name + ", " + cars.findOneName(carIndex);
            return;
        }
        this.name = cars.findOneName(carIndex);
        this.maxMoveStatus = cars.findOneMoveStatus(carIndex);
    }

    public String getName() {
        return name;
    }


    public int getMaxMoveStatus() {
        return maxMoveStatus;
    }
}
