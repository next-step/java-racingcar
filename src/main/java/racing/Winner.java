package racing;

public class Winner {
    private String name;
    private int maxPosition = 0;
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
        if(cars.isWinner(carIndex, maxPosition)){
            replaceWinner(carIndex);
        }
    }

    private void replaceWinner(int carIndex) {
        if (cars.isSharedWinner(carIndex, maxPosition)) {
            this.name = this.name + ", " + cars.findOneName(carIndex);
            return;
        }
        this.name = cars.findOneName(carIndex);
        this.maxPosition = cars.findOneMoveStatus(carIndex);
    }

    public String getName() {
        return name;
    }


    public int getMaxPosition() {
        return maxPosition;
    }
}
