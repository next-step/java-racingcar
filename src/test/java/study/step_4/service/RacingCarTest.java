package study.step_4.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("TestCar", 0);
    }

    @DisplayName("이름과 초기 이동 거리가 올바르게 생성되는지 테스트")
    @Test
    void testConstructor() {
        assertEquals("TestCar", racingCar.getName());
        assertEquals(0, racingCar.getDistance());
    }

    @DisplayName("이동 여부에 따라 거리가 증가했는지 또는 그대로인지 확인")
    @Test
    void testDrive() {
        int initialDistance = racingCar.getDistance();
        int newDistance = racingCar.drive(10, 5);

        assertTrue(newDistance == initialDistance || newDistance == initialDistance + 1);
    }

    @DisplayName("반환된 랜덤 값이 올바른 범위 내에 있는지 확인")
    @Test
    void testGetRandomValue() {
        int bound = 10;
        int randomValue = racingCar.getRandomValue(bound);
        assertTrue(randomValue >= 0 && randomValue < bound);
    }

    @Test
    @DisplayName("여러 번의 drive 호출 테스트: 충분한 시도 후 거리가 증가하는지 확인")
    void testMultipleDrives() {
        int initialDistance = racingCar.getDistance();

        for (int i = 0; i < 100; i++) {
            racingCar.drive(10, 5);
        }

        int finalDistance = racingCar.getDistance();
        assertTrue(finalDistance > initialDistance);
    }

    @Test
    @DisplayName("getName 메서드 테스트: 올바른 이름이 반환되는지 확인")
    void testGetName() {
        assertEquals("TestCar", racingCar.getName());
    }

    @Test
    @DisplayName("getDistance 메서드 테스트: 거리가 올바르게 반환되고 업데이트되는지 확인")
    void testGetDistance() {
        assertEquals(0, racingCar.getDistance());

        racingCar.drive(10, 0);  // 항상 이동하도록 설정
        assertEquals(1, racingCar.getDistance());
    }
}