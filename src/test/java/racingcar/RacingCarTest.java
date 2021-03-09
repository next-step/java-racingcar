package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 테스트")
public class RacingCarTest {

    private InputView inputView;
    private int lastLab;
    private FormulaOne formulaOne;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
        lastLab = 10;
        formulaOne = new FormulaOne(lastLab);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 24})
    @DisplayName("참가 선수 인원이 맞는지 확인")
    public void playerInputTrueTest(int playerCount) throws Exception {
        // given
        boolean result = false;

        // then
        result = inputView.isPlayerLimit(playerCount);

        // when
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, 25, 26})
    @DisplayName("참가 선수 인원이 잘못된지 확인")
    public void playerInputFalseTest(int playerCount) throws Exception {
        // given
        boolean result = false;

        // then
        result = inputView.isPlayerLimit(playerCount);

        // when
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 24})
    @DisplayName("참가 선수를 생성한다.")
    public void playerCreateTest(int playerCount) throws Exception {
        // given
        List<FormulaOne> cars = new ArrayList<>();

        // then
        for(int i = 0; i < playerCount; i++) {
            cars.add(new FormulaOne(lastLab));
        }

        // when
        assertThat(cars.size()).isEqualTo(playerCount);
    }


    @ParameterizedTest
    @ValueSource(ints = {5, 24, 55})
    @DisplayName("목표 서킷 Lab을 입력받는다.")
    public void labInputTest(int labCount) throws Exception {
        // given
        boolean result = false;

        // then
        result = inputView.isLabLimite(labCount);

        // when
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1","5:1","8:1"}, delimiter = ':')
    @DisplayName("랜덤 수 4 이상 1 Lab 진행 테스트")
    public void racingCar1LabTest(int randomValue, int checkLabCount) throws Exception {
        //given
        //when
        formulaOne.formulaOneMoveTest(randomValue);

        //then
        assertThat(formulaOne.getLab()).isEqualTo(checkLabCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"9:2"}, delimiter = ':')
    @DisplayName("랜덤 수 9 이상 2Lab 진행")
    public void racingCar2LabTest(int randomValue, int checkLabCount) throws Exception {
        //given
        //when
        formulaOne.formulaOneMoveTest(randomValue);

        //then
        assertThat(formulaOne.getLab()).isEqualTo(checkLabCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 9})
    @DisplayName("일정확률 이상 시 피트스톱 실행한다")
    public void pitstopInTest(int pitstopRandomValue) throws Exception {
        //given
        FormulaOne formulaOne = new FormulaOne(lastLab);
        //when
        formulaOne.racingCarPitstopTest(pitstopRandomValue);
        //then
        assertThat(formulaOne.getPitstop()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7})
    @DisplayName("일정확률 미만 시 피트스톱 실행 안한다")
    public void pitstopOutTest(int pitstopRandomValue) throws Exception {
        //given
        //when
        formulaOne.racingCarPitstopTest(pitstopRandomValue);
        //then
        assertThat(formulaOne.getPitstop()).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:8", "0:9"}, delimiter = ':')
    @DisplayName("마지막 랩 진행 시 피트스톱 생략한다")
    public void lastLabNotPitstopTest(int labCount, int pitstopRandomValue) throws Exception {
        //given
        lastLab = labCount;
        FormulaOne formulaOne = new FormulaOne(lastLab);
        //when
        formulaOne.racingCarPitstopTest(pitstopRandomValue);
        //then
        assertThat(formulaOne.getPitstop()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8})
    public void pitstopAfterLab(int randomValue) throws Exception {
        //given
        //when
        formulaOne.changePitstop();
        formulaOne.formulaOneMoveTest(randomValue);

        //then
        assertThat(formulaOne.getLab()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    @DisplayName("완주를 하면 종료한다")
    public void completeLabRaceEnd(int labCount) throws Exception {
        //given
        lastLab = labCount;

        //when
        while (true) {
            formulaOne.formulaOneMove();
            if (formulaOne.getLab() >= lastLab) {
                break;
            }
        }

        //then
        assertThat(labCount).isEqualTo(lastLab);
    }
}
