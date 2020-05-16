package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dto.CalculateInfo;

class CalculatorTest {

	@Test
	@DisplayName("µ¡¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void add() {
		assertThat(new CalculateInfo(1,2,"+").calculate()).isEqualTo(3);
	}

	@Test
	@DisplayName("»¬¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void subtract() {
		assertThat(new CalculateInfo(2,1,"-").calculate()).isEqualTo(1);
	}
	
	@Test
	@DisplayName("°ö¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void multiply() {
		assertThat(new CalculateInfo(2,3,"*").calculate()).isEqualTo(6);
	}
	
	@Test
	@DisplayName("³ª´°¼À ±â´É ´ëÇÑ Å×½ºÆ®")
	public void divide() {
		assertThat(new CalculateInfo(4,2,"/").calculate()).isEqualTo(2);
	}
}
