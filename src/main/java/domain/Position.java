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

    private void validate() {
        if (this.value < 0) {
            throw new IllegalArgumentException("Position value must be greater than or equal to 0.");
        }
    }
}
