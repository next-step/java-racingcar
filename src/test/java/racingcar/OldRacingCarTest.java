package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

/**
 * 구현 진행하기전 남겨둔 테스트코드
 */
@DisplayName("구현 들어가기전 진행한 테스트코드")
public class OldRacingCarTest {

    private Scanner scanner;
    private InputStream stdin;
    private RandomDice randomDice;
    private int lastLab;
    private boolean pitstop;

    @BeforeEach
    public void setUp() {
        scanner = new Scanner(System.in);
        randomDice =  new RandomDice();
        lastLab = 10;
        pitstop = false;
    }

    // TODO : 참가 선수 입력을 받는다, 2~24명 제한
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 24})
    @DisplayName("참가 선수 인원이 맞는지 확인")
    public void playerInputTrueTest(int playerCount) throws Exception {
        // given
        boolean result = false;

        // then
        result = isPlayerLimit(playerCount);

        // when
        assertThat(result).isTrue();
    }

    // TODO : 참가 선수 입력을 받는다, 2~24명 제한
    @ParameterizedTest
    @ValueSource(ints = {1, 0, 25, 26})
    @DisplayName("참가 선수 인원이 잘못된지 확.")
    public void playerInputFalseTest(int playerCount) throws Exception {
        // given
        boolean result = false;

        // then
        result = isPlayerLimit(playerCount);

        // when
        assertThat(result).isFalse();
    }

    // TODO : 입력 수 만큼 레이싱카를 생성한다
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 24})
    @DisplayName("참가 선수를 생성한다.")
    public void playerCreateTest(int playerCount) throws Exception {
        // given
        List<FormulaOne> cars = new ArrayList<>();

        // then
        for(int i = 0; i < playerCount; i++) {
            cars.add(new FormulaOne(1));
        }

        // when
        assertThat(cars.size()).isEqualTo(playerCount);
    }


    // TODO : 목표 서킷 Lab 을 입력받는다, 5~55바퀴 제한
    @ParameterizedTest
    @ValueSource(ints = {5, 24, 55})
    @DisplayName("목표 서킷 Lab을 입력받는다.")
    public void labInputTest(int labCount) throws Exception {
        // given
        boolean result = false;

        // then
        result = isLabLimite(labCount);

        // when
        assertThat(result).isTrue();
    }

    public boolean isPlayerLimit(int playerCount) {
        return 2 <= playerCount && playerCount <= 24;
    }

    public boolean isLabLimite(int labCount) {
        return 5 <= labCount && labCount <= 55;
    }


    // TODO : 1Lab 진행 조건은 random 0~9 중 4 이상이다
    @ParameterizedTest
    @CsvSource(value = {"4:1","5:1","8:1"}, delimiter = ':')
    @DisplayName("랜덤 수 4 이상 1 Lab 진행 테스트")
    public void racingCar1LabTest(int randomValue, int checkLabCount) throws Exception {
        //given
        int labCount = 0;

        //when
        labCount = racingCarLabPlus(labCount, randomValue);

        //then
        assertThat(labCount).isEqualTo(checkLabCount);
    }

    // TODO : 2Lab 진행 조건은 random 0~9 중 9 이다
    @ParameterizedTest
    @CsvSource(value = {"9:2"}, delimiter = ':')
    @DisplayName("랜덤 수 9 이상 2Lab 진행")
    public void racingCar2LabTest(int randomValue, int checkLabCount) throws Exception {
        //given
        int labCount = 0;

        //when
        labCount = racingCarLabPlus(labCount, randomValue);

        //then
        assertThat(labCount).isEqualTo(checkLabCount);
    }

    private int racingCarLabPlus(int labCount, int randomValue) {
        if (4 <= randomValue) {
            ++labCount;
        }

        if (9 <= randomValue) {
            ++labCount;
        }

        return labCount;
    }

    // TODO : 랩을 진행할때 마다 random 0~9 중 8 이상이 나오면 타이어교체 피트스톱을 한다.
    @ParameterizedTest
    @ValueSource(ints = {8, 9})
    @DisplayName("일정확률 이상 시 피트스톱 실행한다")
    public void pitstopInTest(int pitstopRandomValue) throws Exception {
        //given
        //when
        //then
        assertThat(racingCarPitstop(1, pitstopRandomValue)).isTrue();
    }

    // TODO : 랩을 진행할때 마다 random 0~9 중 8 미만이 나오면 피트스톱을 안한다.
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7})
    @DisplayName("일정확률 미만 시 피트스톱 실행 안한다")
    public void pitstopOutTest(int pitstopRandomValue) throws Exception {
        //given
        //when
        //then
        assertThat(racingCarPitstop(1, pitstopRandomValue)).isFalse();
    }

    public boolean racingCarPitstop(int labCount, int pitstopRandomValue){
        return (8 <= pitstopRandomValue) && !(lastLab == labCount);
    }


    // TODO : 랩을 진행할때 마다 random 0~9 중 8 이상이 나오면 타이어교체 피트스톱을 한다. 마지막 바퀴라면 진행안한다.
    @ParameterizedTest
    @CsvSource(value = {"10:8", "11:9", "20:8"}, delimiter = ':')
    @DisplayName("마지막 랩 진행 시 피트스톱 생략한다")
    public void lastLabNotPitstopTest(int labCount, int pitstopRandomValue) throws Exception {
        //given
        lastLab = labCount;

        //when
        boolean reuslt = racingCarPitstop(labCount, pitstopRandomValue);

        //then
        assertThat(racingCarPitstop(labCount, pitstopRandomValue)).isFalse();
    }

    // TODO : 피트스톱 상태라면 다음 랩을 진행하기 위한 random 조건은 5 이상이다. 한턴이 지나면 정상적으로 4 로 변한다
    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8})
    public void pitstopAfterLab(int randomValue) throws Exception {
        //given
        pitstop = true;
        int labCount = 0;

        //when
        labCount = racingCarLabPlus(labCount, randomValue);

        //then
        assertThat(labCount).isEqualTo(1);
    }

    // TODO : 모든 선수의 해당 턴이 끝나고 완주한 선수가 존재 시 경주를 종료한다
    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    @DisplayName("완주를 하면 종료한다")
    public void completeLabRaceEnd(int labCount) throws Exception {
        //given
        lastLab = labCount;

        //when
        while (true) {
            labCount = racingCarLabPlus(labCount, randomDice.getRandomValue());

            if (labCount >= lastLab) {
                break;
            }
        }

        //then
        assertThat(labCount).isEqualTo(lastLab);
    }

    public int getRandomIntValue() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
