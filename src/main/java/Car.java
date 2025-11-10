import javax.xml.stream.Location;

public class Car {
    int currentLocation;

    Car() {
        this.currentLocation = 0;
    }

    void moveForward() {
        currentLocation++;
    }

    void play() {
        final boolean madeFirstMove = makeFirstMove();
        if (madeFirstMove) {
            return;
        }
        makeMove();
    }

    private boolean makeFirstMove() {
        if (isFirstMove()) {
            moveForward();
            return true;
        }
        return false;
    }

    private boolean isFirstMove() {
        return currentLocation == 0;
    }

    private void makeMove() {
        final int random = CarRacingRules.randomRange();
        final boolean moveForward = CarRacingRules.determineToGoForwardOrStop(random);
        if (moveForward) {
            moveForward();
        }
    }
}
