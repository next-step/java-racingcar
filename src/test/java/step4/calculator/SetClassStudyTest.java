package step4.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetClassStudyTest {

    private Set<Integer> numbers;

    private int defaultSize = 3;

    @BeforeEach
    void setting() {
        numbers = new HashSet<>();
        for (int i = 1; i <= defaultSize; i++) {
            numbers.add(i);
        }
    }
    @Test
    @DisplayName("Set 사이즈 구하기")
    void calculate_set_size(){
        //Act
        int size = this.numbers.size();
        //Assert
        Assertions.assertEquals(defaultSize, size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("중복코드 없이 Collection에 포함된 데이터확인하기")
    void check_number_contain_with_remove_duplicate_source_code(int target){
        assertThat(numbers.contains(target)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true", "3:true", "4:false", "5:false"},delimiter = ':')
    @DisplayName("중복코드 없이 Collection에 포함된 데이터확인하기")
    void check_number_contain_with_remove_duplicate_source_code_with_csv(int target, boolean expect){
        // Act
        boolean contains = numbers.contains(target);

        // Assert
        assertThat(contains).isEqualTo(expect);
    }

}
