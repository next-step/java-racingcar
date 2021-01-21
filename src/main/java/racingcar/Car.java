package racingcar;

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
        }
    }

    public void printNameAndCurrentPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
