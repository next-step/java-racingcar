package race;

public enum MoveResult {
    MOVED,
    STOPPED;

    public static MoveResult of(boolean moved) {
        return moved ? MOVED : STOPPED;
    }
}
