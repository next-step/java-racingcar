package com.nextstep.camp.racing.infrastructure.view;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.nextstep.camp.racing.domain.exception.ViewDataNotFoundException;
import com.nextstep.camp.racing.infrastructure.view.component.MaxPositionInput;
import com.nextstep.camp.racing.infrastructure.view.component.QuantityInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CreateRacingViewTest {

    @ParameterizedTest
    @MethodSource("provideElementData")
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
    void toViewData_ShouldThrowException_IfRenderNotCalled() {
        Scanner scanner = new Scanner(System.in);
        CreateRacingView view = CreateRacingView.publish(List.of(QuantityInput.create(scanner), MaxPositionInput.create(scanner)));

        assertThatThrownBy(view::toViewData)
            .isInstanceOf(ViewDataNotFoundException.class);
    }
}
