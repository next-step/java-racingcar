package racing.domain;

public class Car {

    private final String name;
    private final CarSetInRace setRace;

    public Car(String name) {
        this.name = name;
        this.setRace = new CarSetInRace();
    }

    public void move(RaceRule rule) {
        if(rule.movementRule()) {
            setRace.move();
            return;
        }
        setRace.stop();
    }

    public String getName() {
        return name;
    }

    public CarSetInRace getRaceSetting() {
        return setRace;
    }

    public int getDistance() {
        return setRace.getMoveSize();
    }

}
