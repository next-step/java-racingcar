package study.race;

import java.util.ArrayList;
import java.util.List;

import study.util.RandomNumber;

public class CarRace {

    private List<CarEntry> entrys;
    private int raceNum;

    public CarRace(int entryNum, int raceNum) {
        entrys = ready(entryNum);
        this.raceNum = raceNum;
    }

    private List<CarEntry> ready(int entryNum) {
        List<CarEntry> readyEntrys = new ArrayList<>();
        for (int i = 0; i < entryNum; i++) {
            Car car = new Car();
            readyEntrys.add(new CarEntry(car));
        }

        return readyEntrys;
    }
    
    public void run() {
        for (int i = 0; i < raceNum; i++) {
            for (CarEntry entry : entrys) {
                int randomNum = RandomNumber.getRandomNumber();
                entry.move(randomNum);
            }
        }
    }

    public List<CarEntry> getRaceResult() {
        return entrys;
    }

}
