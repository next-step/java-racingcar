package carracing.domain;

import carracing.service.CarRacing;
import carracing.service.dto.RacingResult;
import carracing.service.dto.RacingScore;
import carracing.service.dto.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("Engine 클래스 - 랜덤값이 4 이상이면 반드시 움직인다")
    public void engine_move(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
           @Override
           public int nextInt(int bound) {
               return testParam;
           }
        });

        // when then
        assertThat(engine.drive()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("Car 클래스 - 4 이상 값을 리턴하는 엔진을 가진 Car 객체는 반드시 움직인다.")
    public void car_move(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
            @Override
            public int nextInt(int bound) {
                return testParam;
            }
        });

        Car car = new Car("test");
        car.drive(engine);

        // when then
        assertThat(car.inquiryRacingScore().getScore()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0, -1, -2})
    @DisplayName("Engine 클래스 - 랜덤값이 4 미만이면 반드시 멈춘다")
    public void engine_stop(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
            @Override
            public int nextInt(int bound) {
                return testParam;
            }
        });

        // when then
        assertThat(engine.drive()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0, -1, -2})
    @DisplayName("Car 클래스 - 4 미만 값을 리턴하는 엔진을 가진 Car 객체는 움직일 수 없다")
    public void car_stop(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
            @Override
            public int nextInt(int bound) {
                return testParam;
            }
        });

        Car car = new Car("test");
        car.drive(engine);

        // when then
        assertThat(car.inquiryRacingScore().getScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("Cars 생성 - 자동차 명 미입력 시 예외발생")
    public void cars() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Cars("") )
                .withMessageMatching("경주에 참가할 자동차 명을 입력해 주세요.");
    }

    @Test
    @DisplayName("Car 생성 - 자동차 명 미입력 시 예외발생_공백입력")
    public void car_blankCarName() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Car("  ") )
                .withMessageMatching("자동차 이름은 최소 1자 이상 입력되어야 합니다.");
    }

    @Test
    @DisplayName("Car 생성 - 자동차 명 미입력 시 예외발생_null 입력")
    public void car_nameIsNull() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Car(null) )
                .withMessageMatching("자동차 이름은 최소 1자 이상 입력되어야 합니다.");
    }

    @Test
    @DisplayName("Car 생성 - 자동차 명 5자초과 불가")
    public void car_nameLengthIsGreaterThan5() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Car("aaaaaa") )
                .withMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("Car 생성 - 공백 제외 문자길이 5이하인 경우 차량 생성 정상")
    public void car_nameWithBlank() {
        // given
        Car car = new Car(" aaaaa   ");
        String carName = car.getName();

        // when then
        assertThat(5).isEqualTo(carName.length());
    }

    @Test
    @DisplayName("경기점수 등록 - 참가 자동차 수와 경기스코어 수는 같아야 함")
    void registerRacingScore() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        List<RacingScore> racingScores = cars.racingScoreList();

        // when
        cars.driveAll(new Engine());

        // then
        assertThat(cars.getCarList().size()).isEqualTo(racingScores.size());
    }
    
    @Test
    @DisplayName("우승자 명은 참가차량 명에 반드시 포함되어야 한다.")
    void cars_name_winners_name() {
        // given
        String carNames = "pobi,crong,honux";
        Cars cars = new Cars(carNames);
        
        // when
        cars.driveAll(new Engine());
        List<Car> winnerList = cars.chooseWinners();

        // then
        for (Car winner : winnerList) {
            assertThat(carNames).contains(winner.getName());
        }
    }

    @Test
    @DisplayName("Cars 클래스의 최대점수는 Car 클래스의 모든 점수보다 크거나 같아야 한다.")
    void cars_maxScore_car_score() {
        // given
        String carNames = "pobi,crong,honux";
        Cars cars = new Cars(carNames);
        CarRacing carRacing = new CarRacing(5, cars);

        // when
        carRacing.executeRacing();

        // then
        for (Car car : cars.getCarList()) {
            assertThat(cars.maxScore()).isGreaterThanOrEqualTo(car.inquiryRacingScore().getScore());
        }
    }

    @Test
    @DisplayName("Cars 클래스의 최대점수는 경기결과의 모든 점수보다 크거나 같아야 한다.")
    void cars_maxScore_racingResult_score() {
        // given
        String carNames = "pobi,crong,honux";
        Cars cars = new Cars(carNames);
        CarRacing carRacing = new CarRacing(5, cars);

        // when
        RacingResult racingResult = carRacing.executeRacing();

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            for (RacingScore racingScore : roundResult.getRacingScoreList()) {
                assertThat(cars.maxScore()).isGreaterThanOrEqualTo(racingScore.getScore());
            }
        }
    }

    @Test
    @DisplayName("우승자 Car 의 점수는 Cars 클래스의 최대점수값과 같아야 한다.")
    void cars_maxScore_winners_score() {
        // given
        String carNames = "pobi,crong,honux";
        Cars cars = new Cars(carNames);
        CarRacing carRacing = new CarRacing(5, cars);

        // when
        carRacing.executeRacing();
        List<Car> winnerList = cars.chooseWinners();

        // then
        for (Car car : winnerList) {
            assertThat(cars.maxScore()).isEqualTo(car.inquiryRacingScore().getScore());
        }
    }

    @Test
    @DisplayName("우승자 Car는 Cars 에 속한 모든 Car 점수와 비교했을 때 항상 승자이다")
    void winner_alwaysWin() {
        // given
        String carNames = "pobi,crong,honux";
        Cars cars = new Cars(carNames);
        CarRacing carRacing = new CarRacing(5, cars);

        // when
        carRacing.executeRacing();
        List<Car> winnerList = cars.chooseWinners();

        // then
        for (Car winner : winnerList) {
            for (Car car : cars.getCarList()) {
                assertThat(winner.isWinner(car.inquiryRacingScore().getScore())).isTrue();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("반드시 움직이는 엔진을 장착한 차들은 주행 시 반드시 움직인다.")
    void cars_driveAll_alwaysDrive(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
            @Override
            public int nextInt(int bound) {
                return testParam;
            }
        });

        Cars cars = new Cars("pobi,crong,honux");

        // when
        cars.driveAll(engine);

        // then
        for (Car car : cars.getCarList()) {
            assertThat(1).isEqualTo(car.inquiryRacingScore().getScore());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0, -1, -2})
    @DisplayName("반드시 움직이지 않는 엔진을 장착한 차들은 주행 시 반드시 움직이지 않는다.")
    void cars_driveAll_alwaysStop(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
            @Override
            public int nextInt(int bound) {
                return testParam;
            }
        });

        Cars cars = new Cars("pobi,crong,honux");

        // when
        cars.driveAll(engine);

        // then
        for (Car car : cars.getCarList()) {
            assertThat(0).isEqualTo(car.inquiryRacingScore().getScore());
        }
    }

}