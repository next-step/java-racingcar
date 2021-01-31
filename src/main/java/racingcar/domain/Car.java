package racingcar.domain;

public class Car {
    private final String name;
    private int location;

    public Car(String name, int initialLocation) {
        this.name = name;
        this.location = initialLocation;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void moveOrStay(MovementCondition movementCondition) {
        if (movementCondition.satisfies()) {
            this.location++;
            // TODO: 외부에 공개된 메서드에 의해 객체 내부의 상태가 바뀔 수 있는 구조. 개선해보기
            //  항상 새로운 Car 객체를 생성하도록? 그럼 어떤 tradeoff가 있을까?
        }
    }
}
