package racinggame;

public class RaceRunner {

    public static void main(String[] args) {
        Race race = new Race(new RaceResultView(), new RaceConfigurationScanner());
        race.start();
    }
}
