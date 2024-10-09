package race.domain.car;

class Position {
    private int value;

    Position(int value) {
        this.value = value;
    }

    void forward() {
        value++;
    }

    Position max(Position comparePosition) {
        if (this.value > comparePosition.value) {
            return this;
        }

        return comparePosition;
    }

    int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Position comparePosition = (Position) obj;

        return this.value == comparePosition.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
