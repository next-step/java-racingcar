package racing.domain;

public class Car {
    private final Player player;
    private final CarPosition carPosition;

    public Car(Player player, CarPosition carPosition) {
        this.player = player;
        this.carPosition = carPosition;
    }

    public void race(MovingStrategy strategy) {
        if (strategy.isMove()) {
            carPosition.movePosition();
        }

        carPosition.save();
    }

    public int getPositionRecord(int index) {
        return carPosition.getPositionRecord(index);
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    public String getPlayerName() {
        return player.getName();
    }
}
