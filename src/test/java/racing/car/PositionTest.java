package racing.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void maxPosition(){
        Position position = new Position(4);
        assertThat(position.maxPosition(5)).isEqualTo(5);
    }

    @Test
    void isSame(){
        Position position = new Position(4);
        assertThat(position.isSame(4)).isTrue();
        assertThat(position.isSame(5)).isFalse();
    }

    @Test
    void inclease(){
        Position position = new Position(4);
        assertThat(position.increase()).isEqualTo(new Position(5));
    }

    @Test
    void test(){
        Car car1 = new Car("ㅁㅁ", 0);
        car1.isGo(7);
        Car car2 = car1;
        car2.isGo(7);

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(2);
    }
}
