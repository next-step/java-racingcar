package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovingRecord {
    private Name name;
    private List<Position> positions = new ArrayList<>();

    public MovingRecord(Name name) {
        this.name = name;
    }

    public boolean isSame(Name name) {
        return Objects.equals(this.name, name);
    }

    public boolean isLastPositionSame(int position) {
        return Objects.equals(getLastPosition(), position);
    }

    public void addPositionRecord(Position position) {
        positions.add(position);
    }

    public int getLastPosition() {
        if (positions.isEmpty()) {
            throw new RuntimeException("경주 이력이 없습니다.");
        }
        Position lastPosition = positions.get(positions.size() - 1);
        return lastPosition.getPosition();
    }

    public String getCarName() {
        return name.getName();
    }

    public List<Position> getPositions() {
        return positions;
    }
}