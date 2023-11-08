package racing;

public class Racing {
    private Car[] participants;
    private int round;

    public Racing(int cars, int round) {
        this.participants = new Car[cars];
        for (int i=0; i<cars; i++) {
            participants[i] = new Car();
        }
        this.round = round;
    }

    public void race() {
        for (int i=0; i<round; i++) {
            updateCar();
            ResultView.print("");
        }
    }

    private void updateCar() {
        for (Car participant : participants) {
            participant.move();
            participant.showDistance();
        }
    }
}
