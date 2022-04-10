package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingTest {

    @Test
    void 자동차_대수가_맞는지() {
        CarRacing carRacing = new CarRacing(4, 3);
        Assertions.assertThat(carRacing.getParticipatingCarCount()).isEqualTo(4);
    }

    @Test
    void 주어진_횟수가_맞는지() {
        CarRacing carRacing = new CarRacing(4, 3);
        Assertions.assertThat(carRacing.getAttemptCount()).isEqualTo(3);
    }

    @Test
    void 랜덤_한_숫자_0에서_9사이_값을_구한다() {
        Car car = new Car();
        Matcher matcher = Pattern.compile("[0-9]").matcher(String.valueOf(car.randomNumber()));
        Assertions.assertThat(matcher.find()).isTrue();
    }

    @Test
    void 랜덤_값에서_4이상_인_경우_전진한다() {
        Car car = new Car();
        Assertions.assertThat(car.move(4)).isEqualTo("-");
        Assertions.assertThat(car.move(7)).isEqualTo("-");
        Assertions.assertThat(car.move(9)).isEqualTo("-");
    }

    @Test
    void 랜덤_값에서_4미만_인_경우_멈춘다() {
        Car car = new Car();
        Assertions.assertThat(car.move(1)).isEqualTo("");
        Assertions.assertThat(car.move(3)).isEqualTo("");
    }

//    @Test
//    void 경주() {
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
//    }
}

