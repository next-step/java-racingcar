package racingCar;

public class Car {

    String name;
    int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    void forward() {
        this.position += 1;
    }

    void showPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
