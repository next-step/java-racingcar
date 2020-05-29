package test4;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study4.RacingGame;
import study4.ValidationCheck;

class ValidationCheckTest {
	
	ValidationCheck valicationcheck;
	
	@Test
	@DisplayName("이름이 유효하지않는지 체크")
	void 자동차_이름이_유효하는지_체크() {
		
		String carName = "최향";
				
		assertThatExceptionOfType(IllegalArgumentException.class)
         .isThrownBy(() -> {
        	 RacingGame rg = new RacingGame("최향근", 5);
         });
	}
	
	@Test
	@DisplayName("시도 횟수가 유효하지않는지 체크")
	void 시도횟수가_유효한지_체크() {
		
		assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
       	 RacingGame rg = new RacingGame("pobi,choi,hyang", -2);
        });
	}

}
