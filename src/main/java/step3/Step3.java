package step3;

public class Step3 {
    public static void main(String[] args) {
        RaceInput raceInput = new RaceInput();
        Race race = new Race(raceInput.numberOfTry(), raceInput.numberOfCar());
        RaceOutput raceOutput = new RaceOutput(race.cars());
        while (race.isInRace()) {
            race.proceed();
            raceOutput.print();
            race.nextRound();
        }
    }
}
