package racingcar.policy;

public interface MovingPolicy {
    boolean isPossibleMove(int distance);
    int distance();

}
