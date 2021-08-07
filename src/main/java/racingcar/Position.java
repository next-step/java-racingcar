package racingcar;

public class Position {
    int position;

    public Position (int position) {
        this.position = position;
    }

    public Position (Position posToBeCopied) {
        this.position = posToBeCopied.position;
    }

    public Position increase() {
        position++;
        return new Position(position);
    }
}
