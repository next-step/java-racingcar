package step3.domain;

public class Car {
    private final Record record;

    private final String name;

    public Car(String name) {
        this.record = new Record();
        this.name = name;
    }

    public Car(Record record, String name) {
        this.record = record;
        this.name = name;
    }

    public void moveByRandomOnRound(RandomNumber randomNumber) {
        int lastRecord = record.getLastRecord();
        if (randomNumber.make() > 3) {
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

    @Override
    public String toString() {
        return "Car{" +
                "record=" + record +
                ", name='" + name + '\'' +
                '}';
    }
}
