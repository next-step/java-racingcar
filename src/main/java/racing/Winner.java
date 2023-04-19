package racing;

public class Winner {
    private String name;
    private int moveStatus;
    private final Cars cars;

    public Winner(Cars cars){
        this.cars = cars;
        findWinner();
    }

    private void findWinner() {
        this.name = cars.findOneName(0);
        this.moveStatus = cars.findOneMoveStatus(0);

        for (int carIndex = 1; carIndex < cars.count(); carIndex++) {
            checkWinner(carIndex);
        }
    }

    private void checkWinner(int carIndex) {
        if (this.moveStatus > cars.findOneMoveStatus(carIndex)) {
            return;
        }
        replaceWinner(carIndex);
    }

    private void replaceWinner(int carIndex) {
        if (this.moveStatus == cars.findOneMoveStatus(carIndex)) {
            this.name = this.name + ", " + cars.findOneName(carIndex);
            return;
        }
        this.name = cars.findOneName(carIndex);
        this.moveStatus = cars.findOneMoveStatus(carIndex);
    }

    public String getName() {
        return name;
    }


    public int getMoveStatus() {
        return moveStatus;
    }
}
