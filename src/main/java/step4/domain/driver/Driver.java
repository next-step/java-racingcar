package step4.domain.driver;

import step4.domain.driver.car.Car;
import step4.domain.driver.name.Name;
import step4.domain.startegy.move.MoveStrategy;

public class Driver {

    private final String BLANK = " ";
    private final String COLON = ":";

    private Name name;
    private Car car;

    public static Driver from(Name name, Car car) {
        return new Driver(name, car);
    }

    private Driver(Name name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void move(MoveStrategy moveStrategy) {
        car.move(moveStrategy);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(name)   // toString 활용(), 질문있습니다! : 명시하는 것이 좋을까요? 이대로 사용할까요?
                .append(BLANK)
                .append(COLON)
                .append(BLANK)
                .append(car);   // toString 활용(), 질문있습니다! : 명시하는 것이 좋을까요? 이대로 사용할까요?
        return stringBuilder.toString();
    }


}
