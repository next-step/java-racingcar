package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    public void create() throws Exception {
        //given
        Car car = new Car("sean", 10);

        //then
        assertThat(car).isEqualTo(new Car("sean", 10));
    }

    @Test
    @DisplayName("자동차 위치 이동 테스트")
    public void move() throws Exception {
        //given
        Car sean = new Car("sean", 0);
        Car pobi = new Car("pobi", 4);
        Car bibi = new Car("bibi", 9);
        sean.move(() -> true);
        pobi.move(() -> false);
        bibi.move(() -> true);

        //then
        assertThat(sean.getPosition()).isEqualTo(new Position(1));
        assertThat(pobi.getPosition()).isEqualTo(new Position(4));
        assertThat(bibi.getPosition()).isEqualTo(new Position(10));
    }

    @Test
    @DisplayName("우승자 확인 테스트")
    public void isWinner() throws Exception {
        //given
        Position maxPosition = new Position(10);
        Car sean = new Car("sean", 10);
        Car pobi = new Car("pobi", 9);
        Car bibi = new Car("bibi", 10);

        //then
        assertThat(sean.isWinner(maxPosition)).isTrue();
        assertThat(pobi.isWinner(maxPosition)).isFalse();
        assertThat(bibi.isWinner(maxPosition)).isTrue();
    }

    @Test
    @DisplayName("더 큰 이동 범위를 가진 객체 비교 테스트")
    public void hasBiggerPositionThan() throws Exception {
        //given
        Car sean = new Car("sean", 21);
        Car pobi = new Car("pobi", 20);

        //then
        assertThat(sean.hasBiggerPositionThan(pobi.getPosition())).isTrue();
    }
}