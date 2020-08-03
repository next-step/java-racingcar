package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StrategyTest {
// Day 1 : 우선 핵심로직 : whenXXX() & UI로직 : showXXX() 쌍으로 나열 후 분리 예정
    @DisplayName("n : 자동차 대수 입력값 없거나 0일 경우")
    @ParameterizedTest
    @CsvSource
    public void whenZeroOrBlankCarCount() {
        //return null
        //showZeroOrBlankCarCount()
        //실행 결과 println('')
    }

    // int 0 (position) 또는 emptyString을 반환?
    @DisplayName("m : 이동 시행 횟수 입력값 없거나 0일 경우")
    @ParameterizedTest
    @CsvSource
    public void whenZeroOrBlankRacingCount() {
        //return n개의 null값
        //showZeroOrBlankRacingCount()
        //실행 결과 println('') * n
    }

    @DisplayName("1회 이동 시행 시, random값 in (4~9)이면 '전진' 확인")
    @ParameterizedTest
    @CsvSource
    public void whenRndNumIsEqOrLargerThan4DoesForward() {
        //return position = 현재position + 1
        //UI logic : showRndNumIsEqOrLargerThan4DoesForward()
        //println(실행 결과 \n 현재 - 개수 +'-')
    }

    @DisplayName("1회 이동 시행 시, random값 in (0~3)이면 '멈춤' 확인")
    @ParameterizedTest
    @CsvSource
    public void whenRndNumIsSmallerThan4DoesStop() {
        //return position = 현재position
        //UI logic : showRndNumIsSmallerThan4DoesStop()
        //println(실행 결과 \n 현재 - 개수)
    }

    // Day 1. MAX '-', MIN '-' 경우의수 확인하는 것으로 2개 테스트 분기 고민
    @DisplayName("n : 자동차 대수 1개, m : 1개 이상일 경우, 전진:m회 /멈춤:0회")
    @ParameterizedTest
    @CsvSource
    public void whenOneCarRacingMax() {
        //return position = m
        //UI logic : showOneCarRacingMax()
        //println(실행 결과 \n (...) (2m-1)번째 행의 '-' 개수 m개 , (2m)번째 행 '' 개행)
    }

    @DisplayName("n : 자동차 대수 1개, m : 1개 이상일 경우, 전진:0회 /멈춤:m회")
    @ParameterizedTest
    @CsvSource
    public void whenOneCarRacingMin() {
        //return position = 0
        //UI logic : showOneCarRacingMin()
        //println(실행 결과 \n (...) ((2m-1)번째 행의 '-' 개수 0개 , (2m)번째 행 '' 개행
    }

}
