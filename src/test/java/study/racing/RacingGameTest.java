package study.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racing.model.Car;
import study.racing.model.Participants;
import study.racing.model.Winner;
import study.racing.utils.RacingUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("4 미만의 숫자로 자동차 이동 시도 -> 실패")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void move_with_numbers_under_4(int value) {
        Car car = new Car("test", 0);
        car.move(value);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("4 이상의 숫자로 자동차 이동 시도 -> 성공")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9, 10 })
    void move_with_numbers_over_4(int value) {
        Car car = new Car("test", 0);
        car.move(value);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void get_winners() {
        Participants participants = new Participants();
        participants.addParticipant(new Car("car1", 1));
        participants.addParticipant(new Car("car2", 5));
        participants.addParticipant(new Car("car3", 4));

        assertThat(participants.getWinners().get(0).getName()).isEqualTo("car2");
    }
}
