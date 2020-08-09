package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private static Random testRandom;

    @BeforeAll
    public static void setUp() {
        testRandom = () -> 1;
    }

    @Test
    @DisplayName("자동차 대수와 시도횟수를 입력받아 게임을 초기화한다.")
    public void input_carCount_and_create_cars() {
        // given
        Game game = new Game(4, 3, testRandom);

        // then
        assertThat(game.getCars().length).isEqualTo(4);
        assertThat(game.getTryCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤한 값을 생성한다")
    public void create_random_between_1_and_10() {
        Under10Random random = new Under10Random();
        int result = random.getRandomNumber();
        assertThat(result).isBetween(0, 9);
    }

    @Test
    @DisplayName("자동차를 전진시킨다")
    public void move_car() {
        // given
        Car car = new Car();

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 이이면 자동차를 전진시킨다")
    public void move_car_when_dice_is_greater_or_equal_4() {
        // given
        Game game = new Game(1, 0, () -> 4);

        // when
        game.play();

        // then
        assertThat(game.getCars()[0].getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 자동차는 그대로 있는다")
    public void move_car_when_dice_is_less_than_4() {
        // given
        Game game = new Game(1, 0, () -> 3);

        // when
        game.play();

        // then
        assertThat(game.getCars()[0].getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 상태를 출력한다")
    public void print() {
        // given
        Game game = new Game(3, 0, () -> 4);

        // when
        game.play();

        // then
        game.print();

    }

}
