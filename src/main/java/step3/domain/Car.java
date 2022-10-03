package step3.domain;

public class Car {
    private final Record record;

    private final String name;
    private final MovableStrategy movableStrategy;

    public Car(String name, MovableStrategy movableStrategy) {
        this.record = new Record();
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        int lastRecord = record.getLastRecord();
        if (this.movableStrategy.move()) {
            this.record.addRecord(lastRecord + 1);
            return;
        }
        this.record.addRecord(lastRecord);
    }

    public String getName() {
        return name;
    }

    public Record getRecord() {
        return record;
    }
}
