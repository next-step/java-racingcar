package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Calculator;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
	@Test
	@DisplayName("µ¡¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void add() {
		assertThat(calculator.add(1, 2)).isEqualTo(3);
	}

	@Test
	@DisplayName("»¬¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void subStract() {
		assertThat(calculator.subStract(2, 1)).isEqualTo(1);
	}
	
	@Test
	@DisplayName("°ö¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void multifly() {
		assertThat(calculator.multifly(2, 3)).isEqualTo(6);
	}
	
	@Test
	@DisplayName("³ª´°¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void devide() {
		assertThat(calculator.devide(4, 2)).isEqualTo(2);
	}
}
