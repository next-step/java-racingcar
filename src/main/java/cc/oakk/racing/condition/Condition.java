package cc.oakk.racing.condition;

public interface Condition<T> {
    boolean isMeetCondition(T source);
}
