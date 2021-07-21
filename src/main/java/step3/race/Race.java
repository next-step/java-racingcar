package step3.race;

import step3.model.Cars;

public class Race {

    private int raceTimes;

    private Cars cars = new Cars();

    public Race(int carCounts, int raceTimes) {
        this.raceTimes = raceTimes;
        cars.makeCars(carCounts);
    }

    public void doRace(){
        for (int time = 0; time < raceTimes; time++) {
            moveCars();
        }
    }

    private void moveCars() {
        cars.moveCars();
    }

}
