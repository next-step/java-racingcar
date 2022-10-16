package step5.controller;

import step5.strategy.MovableStrategy;
import step5.strategy.RandomStrategy;

public class Step4 {

    public static void main(String[] args) {
        MovableStrategy randomStrategy = new RandomStrategy();
        RaceManager raceManager = new RaceManager(randomStrategy);
        raceManager.startRace();
    }
}
