package org.sko.calculator.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.sko.calculator.Calculator;

class MultiplyHandlerTest {
  private final MultiplyHandler multiplyHandler = new MultiplyHandler();
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = mock(Calculator.class);
  }

  @ParameterizedTest
  @CsvSource({
     "2,3,6",
     "7.1,3,21.3",
     "0,-3,0",
     "-2,1,-2",
     "-2,-5,10"})
  void test(final Double multiplier, final Double multiplicand, final Double expectedResult) {

    final var multiplierExpression = mock(Expression.class);
    final var multiplicandExpression = mock(Expression.class);

    when(calculator.calculate(multiplierExpression)).thenReturn(multiplier);
    when(calculator.calculate(multiplicandExpression)).thenReturn(multiplicand);

    final var multiplyExpression = new Multiply(multiplierExpression, multiplicandExpression);

    final var result = multiplyHandler.evaluate(calculator, multiplyExpression);

    assertThat(result).isCloseTo(expectedResult, Offset.offset(.1));
  }
}
