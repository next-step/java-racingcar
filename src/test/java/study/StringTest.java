package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
	
	@Test
	public void split(){
		String[] values ="1,2".split(",");
		assertThat(values).contains("1");
		assertThat(values).contains("2");
	}
	
	@Test
	public void charAt() {
		assertThatThrownBy(() ->{
			"abc".charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class);
	}	

}
