package step1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Arrays;

public class StringStudyTest {
  StringStudy StringStudy = new StringStudy();

  @Test
  public void splitTest() {
    String[] result1 = StringStudy.split("1,2", ",");
    String[] result2 = StringStudy.split("1", ",");
    
    assertThat(result1).contains(new String[]{"1","2"});
    assertThat(result2).contains(new String[]{"1"});
  }

  @Test
  public void substringTest() {

  }

  @Test
  public void charAtTest() {

  }
}