package racing;

public class Winner {
    public String name;
    public int moveStatus;

    public Winner(Cars cars){
        this.name = cars.find(0).name;
        this.moveStatus = cars.find(0).moveStatus;
        findWinner(cars);
    }

    private void findWinner(Cars cars) {
        for (int i = 1; i < cars.count(); i++) {
            checkWinner(cars, i);
        }
    }

    private void checkWinner(Cars cars, int i) {
        if (this.moveStatus == cars.find(i).moveStatus) {
            this.name = this.name + ", " + cars.find(i).name;
            return;
        }
        if (this.moveStatus < cars.find(i).moveStatus) {
            this.name = cars.find(i).name;
            this.moveStatus = cars.find(i).moveStatus;
        }
    }
}
