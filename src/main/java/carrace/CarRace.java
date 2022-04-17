package carrace;

public class CarRace {
    private static final int GO = 1;
    private static final int STOP = 0;

    private final RandomMoving randomMoving = new RandomMoving();
    private final RecordCarRace recordCarRace = new RecordCarRace();

    private int numberOfCars;
    private int numberOfRaces;


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

    public RecordCarRace getRecordCarRace() {
        return recordCarRace;
    }
}
