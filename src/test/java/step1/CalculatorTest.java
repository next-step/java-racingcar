package step1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	Calculator cal;
	
    @BeforeEach
	void setUp() {
		cal = new Calculator();
	}
	
	@Test
	void doPlus() {
        assertThat(cal.doPlus("3", "4")).isEqualTo(7.0);
        assertThat(cal.doPlus("100", "5")).isEqualTo(105.0);
	}
	
	@Test
	void doMinus() {
        assertThat(cal.doMinus("10", "4")).isEqualTo(6.0);
        assertThat(cal.doMinus("100", "5")).isEqualTo(95.0);
	}
	
	@Test
	void doMultiple() {
        assertThat(cal.doMultiple("10", "4")).isEqualTo(40.0);
        assertThat(cal.doMultiple("100", "5")).isEqualTo(500.0);
	}
	
	@Test
	void doDevide() {
        assertThat(cal.doDevide("10", "4")).isEqualTo(2.5);
        assertThat(cal.doDevide("100", "5")).isEqualTo(20.0);
	}
}
