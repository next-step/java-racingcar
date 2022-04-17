package carrace;

public class CarRace {
    private RandomMoving randomMoving = new RandomMoving();
    private RecordCarRace recordCarRace = new RecordCarRace();

    private int numberOfCars;
    private int numberOfRaces;

    private static final int GO = 1;
    private static final int STOP = 0;

    public CarRace() {
    }

    public CarRace(int numberOfCars, int numberOfRaces) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
    }

    public void startRaces() {
        for (int i = 0; i < this.numberOfRaces; i++) {
            startEachRace();
        }
    }

    private void startEachRace() {
        for (int j = 0; j < this.numberOfCars; j++) {
            recordCarRace.record(resultOfEachCarRacing());
        }
    }
    
    private int resultOfEachCarRacing() {
        int result = 0;
        for (int i = 0; i < this.numberOfRaces; i++) {
            result += move(randomMoving);
        }

        return result;
    }

    public int move(Moving moving) {
        return moving.isMove() ? GO : STOP;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    public RandomMoving getRandomMoving() {
        return randomMoving;
    }

    public void setRandomMoving(RandomMoving randomMoving) {
        this.randomMoving = randomMoving;
    }

    public RecordCarRace getRecordCarRace() {
        return recordCarRace;
    }

    public void setRecordCarRace(RecordCarRace recordCarRace) {
        this.recordCarRace = recordCarRace;
    }
}
