package new_racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private InputView inputView;
    private GrandPrix grandPrix;

    @BeforeEach
    public void setUp(){
        inputView = new InputView();
        grandPrix = new GrandPrix();
    }

    // TODO : UI 경주에 참가할 자동차 수가 유효성 성공 확인
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("입력받은 참가 선수 1명 이상이면 유효성 성공 확인")
    public void playerNumberValidSuccesstest(int playerCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(playerCount)).isTrue();
    }

    // TODO : UI 경주에 참가할 자동차 수 유효성 실패 확인
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("입력받은 참가 선수 1명 미만이면 유효성 실패 확인")
    public void playerNumberValidFailtest(int playerCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(playerCount)).isFalse();
    }

    // TODO : UI 경주에 참가할 자동차 수가 유효성 성공 확인
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("입력받은 진행 횟수 1 이상이면 유효성 성공 확인")
    public void turnCountValidSuccesstest(int turnCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(turnCount)).isTrue();
    }

    // TODO : UI 경주에 참가할 자동차 수 유효성 실패 확인
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("입력받은 진행 횟수 1 미만이면 유효성 실패 확인")
    public void turnCountValidFailtest(int turnCount) throws Exception {
        //given

        //when

        //then
        assertThat(inputView.isValid(turnCount)).isFalse();
    }

    // TODO : 입력된 수 만큼 자동차 생성
    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    @DisplayName("입력 된 값만큼 자동차 생성")
    public void createCarTest(int carSize) throws Exception {
        //given

        //when
        List<Car> cars = grandPrix.createCar(carSize);

        //then
        assertThat(cars.size()).isEqualTo(carSize);
    }

    // TODO : Random.nextInt(10) 이용해서 랜덤값 도출
    @Test
    @DisplayName("랜덤값 가져오기")
    public void getRandomValueTest() throws Exception {
        //given

        //when
        int randomValue = RandomUtil.getValue();

        //then
    }

    // TODO : 자동차는 랜덤값 4 이상만 이동
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8})
    @DisplayName("랜덤값 4 이상만 자동차 이동")
    public void carMoveTest(int randomValue) throws Exception {
        //given
        Car car = new Car();

        //when
        boolean result = car.move(randomValue);

        //then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8})
    @DisplayName("거리 1 이동 확인")
    public void distanceTest(int randomValue) throws Exception {
        //given
        Car car = new Car();

        //when
        car.move(randomValue);

        //then
        assertThat(car.getRecord().getDistance()).isEqualTo(1);
    }

    // TODO : 자동차는 랜덤값 4 미만은 움직임 없음
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤값 4 미만은 움직임 없음 ")
    public void carStopTest(int randomValue) throws Exception {
        //given
        Car car = new Car();

        //when
        boolean result = car.move(randomValue);

        //then
        assertThat(result).isFalse();
    }
}
