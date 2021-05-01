import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingUtilTest {
    /*
    @DisplayName("getRandomNumber 함수가 지정한 randomBound 내에 값이 잘 추출이 되는지 확인")
    @Test
    void getRandomNumberTest(){
        CarRacingUtil carRacingUtil = new CarRacingUtil();
        Integer randomBound = 10;

        for(int i=0; i< 20; i++){
            assertThat(carRacingUtil.getRandomNumber(randomBound)).isNotNull().
                    isPositive().isBetween(0,9);
        }
    }

    @DisplayName("checkCarNameValidity 함수가 지정된 기능이 작동이 되는 지 확인")
    @Test
    void checkCarNameValidityTest(){
        CarRacingUtil carRacingUtil = new CarRacingUtil();
        String carNames = "phone,david,tom";
        String splitDelimiter = ",";
        Integer nameLengthLimit = 5;

        assertThat(carRacingUtil.checkCarNameValidity(carNames, splitDelimiter, nameLengthLimit)).isNotNull().
                isEqualTo(3);

        carNames = "phones,david,tom";
        splitDelimiter = ",";
        nameLengthLimit = 5;

        assertThat(carRacingUtil.checkCarNameValidity(carNames, splitDelimiter, nameLengthLimit)).isNotNull().
                isEqualTo(1);

        carNames = "phone,phone,tom";
        splitDelimiter = ",";
        nameLengthLimit = 5;

        assertThat(carRacingUtil.checkCarNameValidity(carNames, splitDelimiter, nameLengthLimit)).isNotNull().
                isEqualTo(2);
    }
    */
    @DisplayName("getCarNameList 함수의 정상작동 확인")
    @Test
    void getCarNameListTest() {
        CarRacingUtil carRacingUtil = new CarRacingUtil();
        String carNames = "phone,david,tom";
        String splitDelimiter = ",";
        Integer nameLengthLimit = 5;

        assertThat(carRacingUtil.getCarNameList(carNames, splitDelimiter, nameLengthLimit)).isNotNull().
                containsExactly("phone","david","tom");
        
    }

    @DisplayName("runCarRacing 함수의 정상작동 확인")
    @Test
    void runCarRacingTest() {
        CarRacingUtil carRacingUtil = new CarRacingUtil();
        String carNames = "phone,david,tom";
        String splitDelimiter = ",";
        Integer nameLengthLimit = 5, forwardLimit = 4, randomBound = 10;
        List<String> carNameList = null;
        Map<String, Integer> carRacedScope = new HashMap<>();

        carNameList = carRacingUtil.getCarNameList(carNames, splitDelimiter, nameLengthLimit);

        for(String carName : carNameList){
            carRacedScope.put(carName, 0);
        }

        carRacedScope = carRacingUtil.runCarRacing(carRacedScope, forwardLimit, randomBound);
        
//      runCarRacing 결과 값의 유효성 체크
        assertThat(carRacedScope).isNotNull();
        assertThat(carRacedScope.size()).isEqualTo(3);
        assertThat(carRacedScope.get("phone")).isBetween(0,1);
        assertThat(carRacedScope.get("david")).isBetween(0,1);
        assertThat(carRacedScope.get("tom")).isBetween(0,1);
    }

    @DisplayName("getRacingWinner 함수의 정상작동 확인")
    @Test
    void getRacingWinnerTest() {
        CarRacingUtil carRacingUtil = new CarRacingUtil();
        String carNames = "phone,david,tom";
        String splitDelimiter = ",";
        Integer nameLengthLimit = 5, forwardLimit = 4, randomBound = 10;
        List<String> carNameList = null, winnerList = null;
        Map<String, Integer> carRacedScope = new HashMap<>();

        carNameList = carRacingUtil.getCarNameList(carNames, splitDelimiter, nameLengthLimit);

        for(String carName : carNameList){
            carRacedScope.put(carName, 0);
        }

        carRacedScope = carRacingUtil.runCarRacing(carRacedScope, forwardLimit, randomBound);
        winnerList = carRacingUtil.getRacingWinner(carRacedScope);

//      getRacingWinner 결과 값의 유효성 체크
        assertThat(carRacedScope).isNotNull();
        assertThat(carRacedScope.size()).isBetween(1,3);
    }
}