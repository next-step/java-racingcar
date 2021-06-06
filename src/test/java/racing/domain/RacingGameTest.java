package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    RacingGame racing;

    @BeforeEach
    void set() {
        racing = new RacingGame("1,2,3", 7);
    }

    @Test
    @DisplayName("이동 여부 테스트 코드")
    void move() {
        // return 값이 4 미만 이기 때문에 이동하지 않음
        racing.race(new Movable() {
            @Override
            public int move() {
                return 0;
            }
        });
        // return 값이 5 이상 이기 때문에 이동
        racing.race(() -> 5);
        // 메소드 결과 값을 인터페이스를 통해 정할 수 있다.
    }
}
