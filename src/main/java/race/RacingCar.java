package race;

public class RacingCar {
    private final int racingNumber;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCar(int racingNumber, RandomNumberGenerator randomNumberGenerator) {
        this.racingNumber = racingNumber;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private boolean shouldMove(int num) {
        return num >= 4;
    }

    public int move() {
        int randomValue = randomNumberGenerator.generate();
        if (shouldMove(randomValue)) {
            position++;
        }
        return position;
    }

    public void printPosition() {
        String racingNumber = String.format("%02d", this.racingNumber + 1);
        System.out.println("Car " + racingNumber + " : " + "-".repeat(Math.max(0, position)));
    }
}
