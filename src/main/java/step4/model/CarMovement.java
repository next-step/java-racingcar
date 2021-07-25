package step4.model;

public class CarMovement implements MoveStrategy {

    private final int RANDOM_BOUND = 10;
    
    @Override
    public void move(Cars cars) {
        for(Car car:cars.getCars()){
            int movePoint = RandomFactory.getRandomInt(RANDOM_BOUND);
            car.move(movePoint);
        }
    }
}
