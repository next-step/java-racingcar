package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int ADVANCE_CONDITION = 3;
    private int position;
    private String name;

<<<<<<< HEAD
    public Car(String name, int position) {
        this.name = name;
=======
    public Car(int position, String name) {
>>>>>>> Car 불필요한 공백삭제 및 한칸 전진으로 수정
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int newPosition) {
        if(ADVANCE_CONDITION < newPosition) {
            this.position++;
        }
    }

    public int compareTo(Car compareCar) { // override
        // 내림차순
        return compareCar.position - this.position;
    }
}
