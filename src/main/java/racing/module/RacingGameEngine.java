package racing.module;

import java.util.List;
import java.util.Objects;
import racing.Car;
import racing.module.map.BasicRacingMap;
import racing.module.map.RacingMap;
import racing.module.move.CarMoveDecider;
import racing.module.move.BasicCarMoveDecider;

public class RacingGameEngine {

    private List<Car> cars;
    private RacingMap racingMap;
    private CarMoveDecider carMoveDecider;

    public RacingGameEngine(Builder builder) {
        this.cars = builder.cars;
        this.racingMap = builder.racingMap;
        this.carMoveDecider = builder.carMoveDecider;
    }

    public void executeTurn(){
        for (Car car : cars) {
            moveOrStop(car);
            racingMap.drawCar(car.currentPosition());
        }
    }

    private void moveOrStop(Car car) {
        if(carMoveDecider.isMovingForwardCondition()){
            car.moveForward();
        }
    }

    public RacingMap getRacingMap() {
        return this.racingMap;
    }

    public static class Builder{
        private List<Car> cars;
        private RacingMap racingMap;
        private CarMoveDecider carMoveDecider;

        public Builder(List<Car> cars){
            this.cars = cars;
        }

        public Builder racingMap(RacingMap racingMap){
            this.racingMap = racingMap;
            return this;
        }

        public Builder carMoveDecider(CarMoveDecider carMoveDecider){
            this.carMoveDecider = carMoveDecider;
            return this;
        }

        public RacingGameEngine build(){
            if(isMapDefaultCondition()){
                racingMap = new BasicRacingMap();
            }
            if(isCarMoveDeciderDefaultCondition()) {
                carMoveDecider = new BasicCarMoveDecider();
            }
            return new RacingGameEngine(this);
        }

        private boolean isCarMoveDeciderDefaultCondition() {
            return Objects.isNull(carMoveDecider);
        }

        private boolean isMapDefaultCondition() {
            return Objects.isNull(racingMap);
        }
    }


}
