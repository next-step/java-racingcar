package study.race.domain;

import java.util.ArrayList;
import java.util.List;

import study.race.condition.RaceConditionNumber;

public class CarRace {

    private RaceConditionNumber conditionNumber;

    private List<CarEntry> entrys;
    private int raceNum;

    private List<String> winner;
    

    public CarRace(RaceConditionNumber randomNumber) {
        this.conditionNumber = randomNumber;
    }


    public void ready(String[] entryNames, int raceNum) {
        this.raceNum = raceNum;

        this.entrys = new ArrayList<>();
        for (String entryName : entryNames) {
            Car car = new Car(entryName);
            this.entrys.add(new CarEntry(car));
        }
    }
    

    public void run() {
        this.winner = new ArrayList<>();

        if (this.raceNum < 0 || this.entrys == null) {
            throw new IllegalStateException("레이스 조건이 충족되지 않았습니다");
        }

        for (int i = 0; i < this.raceNum; i++) {
            moveAllRaceEntry(this.entrys);
        }

        int maxScore = 0;
        for (CarEntry entry : this.entrys) {
            maxScore = findMaxScore(entry, maxScore);
        }

        for (CarEntry entry : this.entrys) {
            findWinner(entry, maxScore);
        }
    }


    private void moveAllRaceEntry(List<CarEntry> entrys) {
        winner.clear();
        for (CarEntry entry : entrys) {
            int randomNum = this.conditionNumber.fetch();
            entry.move(randomNum);
        }
    }


    private int findMaxScore(CarEntry entry, int maxScore) {
        if (entry.isAboveScore(maxScore)) {
            return entry.getCar().getScore();
        }

        return maxScore;
    }


    private void findWinner(CarEntry entry, int maxScore) {
        if (entry.isAboveScore(maxScore)) {
            winner.add(entry.getEntryName());
        }
    }


    public List<CarEntry> getRaceResult() {
        return this.entrys;
    }


    public List<String> winner() {
        if (this.winner == null) {
            throw new IllegalStateException("레이스가 실행되지 않았습니다");
        }

        return this.winner;
    }

}
