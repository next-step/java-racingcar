package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    // ---요구사항1---
    // ,로 split 했을 때 1과 2로 잘 분리되는지 확인하기
    @Test
    @DisplayName("요구사항1_split 사용하기(1,2 split)")
    void split_1(){
        // 테스트 데이터
        String testData = "1,2";
        // 테스트데이터 split
        String[] result = testData.split(",");
        // assertThat
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1_split 사용하기(1 split)")
    void split_2(){
        // 테스트 데이터
        String testData = "1";
        // 테스트데이터 split
        String[] result = testData.split(",");
        // assertThat
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    // ---요구사항2---
    // subString을 이용해 ()를 제거하고 1,2 반환
    @Test
    @DisplayName("요구사항2_substring 사용하기")
    void substr(){
        // 테스트 데이터
        String testData = "(1,2)";
        // subSstring을 이용해 처음과 마지막 문자를 제외한 문자열 가져오기
        String substr = testData.substring(1,testData.length()-1);
        assertThat(substr).isEqualTo("1,2");
    }

    // ---요구사항3---
    // charAt()메소드를 이용해 특정 위치의 문자를 가져온다.
    // 위치값을 벗어날 경우 StringIndexOutOfBoundsException이 발생하는 부분에 대한 테스트 구현
    @Test
    @DisplayName("요구사항3_charAt()을 이용한 특정위치 문자 가져오기")
    void charAt(){
        // 테스트 데이터
        String testData = "abcde";

        // 방법1
//        assertThatThrownBy(() -> {
//            testData.charAt(testData.length());
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("String index out of range");

        // 방법2
//        assertThatExceptionOfType(IndexOutOfBoundsException.class)
//                .isThrownBy(() -> {
//                    testData.charAt(testData.length());
//                });

        // 방법2에 메세지 추가
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    testData.charAt(testData.length());
                }).withMessageMatching("String index out of range: 5");

    }
}
