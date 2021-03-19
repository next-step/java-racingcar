package step4.domain.car.position;

public final class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public final void increase() {
        position++;
    }

    public final int position() {
        return position;
    }

}
