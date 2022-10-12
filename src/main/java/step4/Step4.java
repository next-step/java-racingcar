package step4;

public class Step4 {

    public static void main(String[] args) {
        MovableStrategy randomStrategy = new RandomStrategy();
        RaceManager raceManager = new RaceManager(randomStrategy);
        raceManager.startRace();
    }
}
