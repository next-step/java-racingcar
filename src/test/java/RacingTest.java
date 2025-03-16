import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("레이싱 메소드 테스트")
class RacingTest {

    @Test
    @DisplayName("점수를 기록합니다.")
    void start_경기_시작_후_점수_기록() {
        //given
        Racing racing = new Racing(2,5);

        //when
        racing.start();

        //then
        assertThat(racing.getScore().size()).isEqualTo(5);
    }

}