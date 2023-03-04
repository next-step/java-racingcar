package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() { car = new Car(); }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void carRacing(String strings) {
        car.carRacingStart(strings, 5);
    }

    @Test
    void carRacingUserTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carList = sc.nextLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int playNumber = sc.nextInt();
        car.carRacingStart(carList, playNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"슈퍼자동차"})
    void carNameChk(String strings) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> car.carNameChk(strings));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    @DisplayName("pobi,woni,jun 의 3번 레이싱 결과")
    void carRacingPlayUserList(String strings) {
        car.carRacingOrder(strings, 3);
    }

}
