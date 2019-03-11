package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringExpressionValidatorTest {

    //19.03.11 클래스 분리에 따라 TEST CLASS도 분리
    //TODO 입력값이 비정상적인 case 생각해보기 (요구사항 없음, 숫자만, 연산자-숫자 순서 오류 등)

    @Test
    public void 입력값이_null이거나_공백인경우() {
        boolean isOk = false;

        isOk = StringExpressionValidator.validateExpression("");
        assertThat(isOk).isEqualTo(false);

        isOk = StringExpressionValidator.validateExpression(null);
        assertThat(isOk).isEqualTo(false);
    }

    @Test
    public void 문자열입력_비정상_케이스_테스트() {
        boolean isOk = false;
        String text = "1 + 2 - 3 * 4 / 5";

        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(true);

        text = "1 + + 2 - 3 * 4 / 5";
        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(false);
    }

    @Test
    public void 두자리_이상_숫자_입력값_확인() {
        boolean isOk = false;
        String text = "10 + 2 - 3 * 4 / 5";

        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(true);

        text = "100 + 20 - 33 * 4 / 51";
        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(true);
    }

}