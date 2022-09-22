package racing_car.step3.domain;

import racing_car.step3.dto.CarDTO;

import java.util.Objects;

public class Position {
    private final int position;
    
    public Position(int position) {
        this.position = position;
    }
    
    public Position increase() {
        return new Position(position + 1);
    }
    
    public int getPosition() {
        return this.position;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
