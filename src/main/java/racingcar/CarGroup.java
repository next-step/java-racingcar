package racingcar;

public class CarGroup {
    private Car[] carGroup;

    public CarGroup(int number) {
        carGroup = new Car[number];
        for (int i = 0; i < carGroup.length; i++) {
            carGroup[i] = new Car();
        }
    }

    public void updateCarArrayPosition() {
        for (int i = 0; i < carGroup.length; i++) {
            carGroup[i].updatePosition();
        }
    }

    public int carGroupLength() {
        return carGroup.length;
    }

    public int position(int carIndex) {

        return carGroup[carIndex].position();
    }
}
