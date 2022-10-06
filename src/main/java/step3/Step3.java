package step3;

public class Step3 {

    public static void main(String[] args) {
        MovableStrategy randomStrategy = new RandomStrategy();
        RaceManager raceManager = new RaceManager(randomStrategy);
        raceManager.startRace();
    }
}
