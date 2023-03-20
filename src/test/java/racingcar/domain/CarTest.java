package racingcar.domain;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class Car {
    private final String name;
    private int position;

    private final static int MAXIMUM_NAME_LENGTH = 5;
    private final static int DEFAULT_POSITION = 0;


    public Car(final String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(final String name, final int position) {
        if(name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        final int randomNumber = new Random().nextInt(10);
        move(randomNumber);
    }
    public void move(final int condition) {
        if(condition > 4) {
            position++;
        }
    }

    public void stop() {
        final int randomNumber = getRandomNumber();
        if(randomNumber > 4) {
            position++;
        }
    }

    protected int getRandomNumber() {
        return new Random().nextInt(10);
    };


}

public class CarTest {

    @DisplayName("자동차는 이름을 가진다")
    @ValueSource(strings = {"jason", "박재성"})
    @ParameterizedTest
    @Test
    void name() {
        final Car car = new Car("Jason");
        assertThat(car.getName()).isEqualTo("Jason");

    }

    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    @Test
    public void name_length() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("동해물과 백두산이"));

    }

    @DisplayName("자동차의 초기 위치는 0이다")
    @Test
    void default_position() {
        final Car car = new Car("Jason");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차가 이동한다")
    @Test
    void move() {
        final Car car = new Car("Jason") {
            @Override
            protected int getRandomNumber() {
                return 4;
            }
        };

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 정지한다")
    @Test
    void stop() {
        final Car car = new Car("Jason") {
            @Override
            protected int getRandomNumber() {
                return 4;
            }
        };

        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
