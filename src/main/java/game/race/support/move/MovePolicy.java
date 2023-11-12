package game.race.support.move;

public abstract class MovePolicy {

    public abstract int move(int number);

    public abstract int getMoveCount(int policyNumber);
}
