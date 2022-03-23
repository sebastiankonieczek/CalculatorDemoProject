package org.sko.calculator.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.sko.calculator.Calculator;

class MinusHandlerTest {
  private final MinusHandler minusHandler = new MinusHandler();
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = mock(Calculator.class);
  }

  @ParameterizedTest
  @CsvSource({
     "2,3,-1",
     "7.1,3,4.1",
     "-2,-3,1",
     "-3,0,-3"})
  void test(final Double minuend, final Double subtrahend, final Double expectedResult) {

    final var minuendExpression = mock(Expression.class);
    final var subtrahendExpression = mock(Expression.class);

    when(calculator.calculate(minuendExpression)).thenReturn(minuend);
    when(calculator.calculate(subtrahendExpression)).thenReturn(subtrahend);

    final var minusExpression = new Minus(minuendExpression, subtrahendExpression);

    final var result = minusHandler.evaluate(calculator, minusExpression);

    assertThat(result).isCloseTo(expectedResult, Offset.offset(.1));
  }
}
