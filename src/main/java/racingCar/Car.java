package racingCar;

public class Car {

    String name; // 자동차 이름
    int position; // 자동차 위치

    /**
     * 생성자
     *
     * @param name
     */
    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    /**
     * 전진
     */
    void forward() {
        this.position += 1;
    }

    /**
     * 현재 위치 값 출력
     */
    void showPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
