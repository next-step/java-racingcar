package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    @Test
    void calculateSentenceTest(){
        Calculator c = new Calculator();
        assertThat(c.calculateSentence("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence("3 & 8");
        });
    }

    /*@Test
    void makeDataArrTest(){
        Calculator c = new Calculator();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.makeDataArr("");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.makeDataArr(" ");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.makeDataArr("    ");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.makeDataArr("1 & 2");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.makeDataArr( "* 3 6");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.makeDataArr( "1 * ");
        });

        assertThat(c.makeDataArr("2 + 3 * 4 / 2")).containsExactly("2","+","3","*","4","/","2");
    }*/

    /*@Test
    void calculateCurrTest(){
        Calculator c = new Calculator();
        String[] dataArr = new String[]{"2","+","3","*","4","/","2"};
        int result = c.calculateCurr(dataArr, dataArr.length-1);
        assertThat(result).isEqualTo(10);
    }*/

    /*@Test
    void isOddDataButNotNumberTest(){
        Calculator c = new Calculator();
        assertThat(c.isOddDataButNotNumber(new String[]{"1","a","3","a","f"})).isEqualTo(true);
        assertThat(c.isOddDataButNotNumber(new String[]{"","a","0","a","3"})).isEqualTo(true);
        assertThat(c.isOddDataButNotNumber(new String[]{"1","a","5","a","5"})).isEqualTo(false);
    }*/

   /* @Test
    void isEvenDataButNotSymbolTest(){
        Calculator c = new Calculator();
        assertThat(c.isEvenDataButNotSymbol(new String[]{"1","a","3"})).isEqualTo(true);
        assertThat(c.isEvenDataButNotSymbol(new String[]{""," ","0"})).isEqualTo(true);
        assertThat(c.isEvenDataButNotSymbol(new String[]{"","%","0"})).isEqualTo(true);
        assertThat(c.isEvenDataButNotSymbol(new String[]{"","//","0"})).isEqualTo(true);
        assertThat(c.isEvenDataButNotSymbol(new String[]{"","++","0"})).isEqualTo(true);
        assertThat(c.isEvenDataButNotSymbol(new String[]{"1","+",""})).isEqualTo(false);
        assertThat(c.isEvenDataButNotSymbol(new String[]{"1","-",""})).isEqualTo(false);
        assertThat(c.isEvenDataButNotSymbol(new String[]{"1","*",""})).isEqualTo(false);
        assertThat(c.isEvenDataButNotSymbol(new String[]{"1","/",""})).isEqualTo(false);
    }*/


}