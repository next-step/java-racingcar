package racing.model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.IntStream;

/*
 *
 * Position
 *
 * @version 1.0.0
 *
 * 2021-11-23
 *
 * Copyright tnals1422
 */
public class Position {

    private static final int CRITERIA = 4;

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public boolean isTopPosition(List<Position> positions) {
        return this.position >= getTopPosition(positions);
    }

    private int getTopPosition(List<Position> positionList) {
        return positionList.stream()
                .mapToInt(position -> position.position)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public Position moveOnSatisfiedCondition(int condition) {
        if (condition > CRITERIA) {
            return new Position(position + 1);
        }
        return this;
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

    public String convertToSymbol(String symbol) {
        String result = "";
        if (this.position > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            IntStream.range(0, this.position)
                    .forEach(j -> stringBuilder.append(symbol));
            result = stringBuilder.toString();
        }
        return result;
    }
}
