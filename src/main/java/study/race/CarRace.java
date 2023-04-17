package study.race;

import java.util.ArrayList;
import java.util.List;

import study.race.condition.RaceConditionNumber;

public class CarRace {

    private RaceConditionNumber conditionNumber;

    private List<CarEntry> entrys;
    private int raceNum;

    public CarRace(RaceConditionNumber randomNumber) {
        this.conditionNumber = randomNumber;
    }

    public void ready(int entryNum, int raceNum) {
        this.raceNum = raceNum;

        this.entrys = new ArrayList<>();
        for (int i = 0; i < entryNum; i++) {
            Car car = new Car();
            this.entrys.add(new CarEntry(car));
        }
    }
    
    public void run() {
        if (this.raceNum < 0 || this.entrys == null) {
            throw new IllegalStateException("레이스 조건이 충족되지 않았습니다");
        }

        for (int i = 0; i < this.raceNum; i++) {
            moveAllRaceEntry(this.entrys);
        }
    }

    private void moveAllRaceEntry(List<CarEntry> entrys) {
        for (CarEntry entry : entrys) {
            int randomNum = this.conditionNumber.fetch();
            entry.move(randomNum);
        }
    }

    public List<CarEntry> getRaceResult() {
        return this.entrys;
    }

}
