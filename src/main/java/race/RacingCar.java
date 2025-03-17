package race;

public class RacingCar {
    private int racingNumber;
    private int position;

    public RacingCar(int racingNumber) {
        this.racingNumber = racingNumber;
    }

    private boolean shouldMove(int num) {
        return num >= 4;
    }

    public int move(int i) {
        if (shouldMove(i)) {
            position++;
        }
        return position;
    }

    public void printPosition() {
        String racingNumber = String.format("%02d", this.racingNumber + 1);
        System.out.println("Car " + racingNumber + " : " + "-".repeat(Math.max(0, position)));
    }
}
