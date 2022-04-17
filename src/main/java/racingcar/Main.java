package racingcar;

public class Main {
    public static void main(String[] args) {
        int carCount = IntScanner.insertCarCount();
        int raceCount = IntScanner.insertRaceCount();

        Race race = new Race(carCount, raceCount);
        race.startRace();
    }
}
