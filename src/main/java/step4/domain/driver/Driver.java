package step4.domain.driver;

import step4.domain.driver.car.Car;
import step4.domain.driver.name.Name;
import step4.domain.startegy.move.MoveStrategy;
import step4.domain.startegy.name.NamingStrategy;

public class Driver implements Cloneable {

    private final String BLANK = " ";
    private final String COLON = ":";

    private Name name;
    private Car car;

    private Driver(Name name, Car car) {
        this.name = name;
        this.car = car;
    }

    // 깊은 복사를 위해 아래와 같이 처리했습니다.
    private Driver(Driver other, NamingStrategy strategy) {
        this.name = Name.from(other.name.toString(), strategy);
        this.car = Car.newInstance(other.car);
    }

    public static Driver from(Name name, Car car) {
        return new Driver(name, car);
    }

    public static Driver newInstance(Driver other, NamingStrategy strategy) {
        return new Driver(other, strategy);
    }

    public void move(MoveStrategy moveStrategy) {
        car.move(moveStrategy);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(name)   // toString() 활용, 다만, 명시하는 것이 좋을까요? 이대로 사용하는 것이 좋을까요?
                .append(BLANK)
                .append(COLON)
                .append(BLANK)
                .append(car);
        return stringBuilder.toString();
    }

}
