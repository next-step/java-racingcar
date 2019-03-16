package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void init_car() {
        Car car = new Car("a");
        assertThat(car.getMileage()).isEqualTo(0);
    }

    @Test
    public void check_if_car_has_name() {
        Car car = new Car("joont92");
        assertThat(car.getName()).isEqualTo("joont92");
    }

    @Test
    public void go_when_rule_passed() {
        Car car = new Car("joont92");
        Rule rule = new AlwaysAccessRule();
        car.move(rule);
        car.move(rule);
        assertThat(car.getMileage()).isEqualTo(2);
    }

    @Test
    public void stop_when_rule_not_passed() {
        Car car = new Car("joont92");
        Rule rule = new AlwaysDenyRule();
        car.move(rule);
        car.move(rule);
        assertThat(car.getMileage()).isEqualTo(0);
    }

    class AlwaysAccessRule implements Rule{
        @Override
        public boolean canPass() {
            return true;
        }
    }

    class AlwaysDenyRule implements Rule{
        @Override
        public boolean canPass() {
            return false;
        }
    }
}
