package racingcar.domain;

public class MockCar implements Car{
    private String name;
    private int position;

    public MockCar(String name, int position){
        this.name = name;
        this.position = position;
    }

    @Override
    public void move() {

    }

    @Override
    public void printCurrentPosition() {

    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}
