package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringTest2 {

    @BeforeEach
    void setUp(){
        System.out.println("SetUp");
    }

    @Test
    void subString1(){
        System.out.println("SubString1");
        String[] result = "(1,2)".substring(0, 1");
    }
}
