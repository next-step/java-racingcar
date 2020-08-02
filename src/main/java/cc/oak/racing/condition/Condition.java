package cc.oak.racing.condition;

public interface Condition<T> {
    boolean isMeetCondition(T source);
}
