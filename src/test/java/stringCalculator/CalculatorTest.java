package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.CommonCalculator;

class CalculatorTest {

    private CommonCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new CommonCalculator();
    }
    
	@Test
	@DisplayName("µ¡¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void add() {
		assertThat(calculator.add(1, 2)).isEqualTo(3);
	}

	@Test
	@DisplayName("»¬¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void subtract() {
		assertThat(calculator.subtract(2, 1)).isEqualTo(1);
	}
	
	@Test
	@DisplayName("°ö¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void multiply() {
		assertThat(calculator.multiply(2, 3)).isEqualTo(6);
	}
	
	@Test
	@DisplayName("³ª´°¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void divide() {
		assertThat(calculator.divide(4, 2)).isEqualTo(2);
	}
}
