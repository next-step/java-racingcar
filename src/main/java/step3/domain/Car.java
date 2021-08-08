package step3.domain;

public class Car {

<<<<<<< HEAD:src/main/java/step3/Car.java
=======
    private final String DASH = "-";
    private int moveNumber;
    private StringBuilder distance = new StringBuilder();

>>>>>>> 3b065af1 (refactor : StringBuilder 사용하여 미리 distance를 갖고있도록 변경):src/main/java/step3/domain/Car.java
    public Car(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    private int distance = 0;
    private int moveNumber;

    public void move(int randomNum) {

        if(randomNum >= moveNumber) {
            distance.append(DASH);
        }

    }

    public String getDistance() {
        return distance.toString();
    }

}
