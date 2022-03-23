package org.sko.calculator.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.sko.calculator.Calculator;

class DivideHandlerTest {
  private final DivideHandler divideHandler = new DivideHandler();
  private Calculator calculator;

  @BeforeEach
  void setUp() {

    calculator = mock(Calculator.class);
  }

  @ParameterizedTest
  @CsvSource({
     "6,3,2",
     "7.1,1,7.1",
     "0,-3,0",
     "-4,2,-2",
     "-10,-5,2"})
  void test(final Double dividend, final Double divisor, final Double expectedResult) {

    final var dividendExpression = mock(Expression.class);
    final var divisorExpression = mock(Expression.class);

    when(calculator.calculate(dividendExpression)).thenReturn(dividend);
    when(calculator.calculate(divisorExpression)).thenReturn(divisor);

    final var divideExpression = new Divide(dividendExpression, divisorExpression);

    final var result = divideHandler.evaluate(calculator, divideExpression);

    assertThat(result).isCloseTo(expectedResult, Offset.offset(.1));
  }

  @Test
  void test_division_by_zero_throws_arithmetic_exception() {

    final var dividendExpression = mock(Expression.class);
    final var divisorExpression = mock(Expression.class);

    when(calculator.calculate(divisorExpression)).thenReturn(0d);

    final var divideExpression = new Divide(dividendExpression, divisorExpression);

    assertThatThrownBy(() -> divideHandler.evaluate(calculator, divideExpression))
        .isInstanceOf(ArithmeticException.class)
        .hasMessage("Division by zero");
  }
}
