package racingGame.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarDTOTest {
    RacingCarDTO dto;

    @Before
    public void setUp() {
        dto = new RacingCarDTO("test1", 5);
    }

    @Test
    public void 자동차_이름() {
        assertThat(dto.getName()).isEqualTo("test1");
    }

    @Test
    public void 자동차_위치() {
        assertThat(dto.getPosition()).isEqualTo(5);
    }

    @Test
    public void 자동차가_특정_위치에_있는지_판단() {
        assertThat(dto.isMatchPosition(5)).isEqualTo(true);
    }
}