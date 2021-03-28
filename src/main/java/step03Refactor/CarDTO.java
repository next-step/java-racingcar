package step03Refactor;

import static step03Refactor.Config.*;

public class CarDTO {
    private Position position;
    private Name name;

    public CarDTO(Car car) {
        this.position = new Position(car.getCarPosition());
        this.name = new Name(car.getCarName());
    }

    @Override
    public String toString() {
        return name.getName() + DELIMITER + getCarMoveRangeToString();
    }

    private String getCarMoveRangeToString() {
        StringBuilder moveRange = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            moveRange.append(MOVE_RANGE);
        }
        return String.valueOf(moveRange);
    }

    public String getWinnerName(int winnerCount) {
        return addDelimiter(winnerCount) + name.getName();
    }

    private String addDelimiter(int winnerCount) {
        if (winnerCount > ADD_DELIMITER_COUNT) {
            return CAR_DELIMITER;
        }
        return "";
    }
}
