package study1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Set Collection에 대한 학습 테스트
 * 
 */
public class SetTest {
	private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
    @Test
    void sizeTest() {
    	int i=0;
    	Iterator ir = numbers.iterator();
    	while(ir.hasNext()) {
    		i++;
    	}
    	assertEquals(i, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containTest(int i) {
      assertThat(numbers.contains(i)).isTrue();
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containTest2(int i, boolean b) {
    	boolean bb = false; // 초기화
    	if( numbers.contains(i)) {
    		bb = true;
    		assertEquals(i, b);
    	}
			assertEquals(i, b);	
    }
}
