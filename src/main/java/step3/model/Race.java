package step3.model;

public class Race {

    private final Integer rounds;

    private final Integer carNumbers;

    public Race(Integer carNumbers, Integer rounds) {
        this.carNumbers = carNumbers;
        this.rounds = rounds;
    }

    public void race() {
        RacingCars racingCars = new RacingCars(carNumbers);
        for (int i = 0; i < this.rounds; i++) {
            new Round(racingCars).race();
        }
    }
}
