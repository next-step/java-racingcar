package domain;

class Position {
    private int value = 0;

    public void increase() {
        this.value++;
    }

    @Override
    public String toString() {
        return "-".repeat(this.value);
    }
}
