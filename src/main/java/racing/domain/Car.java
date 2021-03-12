package racing.domain;

import java.util.stream.Stream;

public class Car {
    public static final int NAME_LENGTH = 5;

    private final String name;
    private int numberOfAdvance = 0;

    public Car(String name) {
        validationName(name);
        this.name = name;
    }

    public int getNumberOfAdvance(){
        return numberOfAdvance;
    }

    public void validationName(String name) {
        if(name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void advance(GameCondition condition) {
        if (condition.moveCondition()) {
            numberOfAdvance++;
        }
    }

    public String getName() {
        return name;
    }

    public String getAdvanceProgress() {
        return Stream.generate(()-> "-")
                .limit(numberOfAdvance)
                .reduce("-", (a, b) -> a + b);
    }

}
