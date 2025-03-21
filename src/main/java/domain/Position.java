package domain;

class Position {
    private int value = 0;

    public void move() {
        this.value++;
    }

    @Override
    public String toString() {
        return "-".repeat(this.value);
    }
}
