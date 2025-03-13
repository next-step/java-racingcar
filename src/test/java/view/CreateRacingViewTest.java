package view;

import exception.ViewDataNotFoundException;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CreateRacingViewTest {

    @ParameterizedTest
    @MethodSource("provideElementData")
    @DisplayName("다양한 입력값에 대해 toViewData()가 올바른 데이터를 반환하는지 테스트")
    void toViewData_ShouldReturnCorrectData_AfterRender(String quantityValue, String maxPositionValue) {
        String simulatedInput = quantityValue + "\n" + maxPositionValue + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Scanner scanner = new Scanner(System.in);
        List<Element> elements = List.of(QuantityInput.create(scanner), MaxPositionInput.create(scanner));
        CreateRacingView view = CreateRacingView.publish(elements);

        view.render();
        ViewData viewData = view.toViewData();

        assertThat(viewData.get("quantity")).isEqualTo(quantityValue);
        assertThat(viewData.get("maxPosition")).isEqualTo(maxPositionValue);
    }

    static Stream<Arguments> provideElementData() {
        return Stream.of(
            Arguments.of("5", "3"),
            Arguments.of("10", "0"),
            Arguments.of("1", "1"),
            Arguments.of("100", "50")
        );
    }

    @Test
    @DisplayName("render() 실행 없이 toViewData() 호출 시 예외 발생")
    void toViewData_ShouldThrowException_IfRenderNotCalled() {
        Scanner scanner = new Scanner(System.in);
        CreateRacingView view = CreateRacingView.publish(List.of(QuantityInput.create(scanner), MaxPositionInput.create(scanner)));

        assertThatThrownBy(view::toViewData)
            .isInstanceOf(ViewDataNotFoundException.class);
    }
}
