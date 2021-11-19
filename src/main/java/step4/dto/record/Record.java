package step4.dto.record;


import step4.dto.count.Position;

public class Record {

    private String carName;
    private Position position;

    public Record(String carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int currentPosition() {
        return this.position.getPosition();
    }
}
