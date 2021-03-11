import java.util.stream.Stream;

public class Car {
    private int numberOfAdvance = 0;
    private String name;

    public Car(String name) {
        this.name = name;
        validationName();
    }

    public int getNumberOfAdvance(){
        return this.numberOfAdvance;
    }

    public void validationName() {
        if(name.length() > 5) {
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
        return name + " : " + Stream.generate(()-> "-")
                .limit(numberOfAdvance)
                .reduce("-", (a, b) -> a + b);
    }

}
