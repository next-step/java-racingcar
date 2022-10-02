package racing;

public class Track {
    private final Car[] cars;

    Track(Car[] cars) {
        this.cars = cars;
    }

    public void start(int reps) {
        for (int rep = 0; rep < reps; rep++) {
            this.startOneRep();
        }
    }

    private void startOneRep() {
        for (Car car : this.cars) {
            ResultView.printMove(car.move());
        }
        System.out.println();
    }
}
