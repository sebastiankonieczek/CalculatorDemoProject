package org.sko.calculator.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.sko.calculator.Calculator;

class PlusHandlerTest {
  private final PlusHandler plusHandler = new PlusHandler();
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = mock(Calculator.class);
  }

  @ParameterizedTest
  @CsvSource({
     "2,3,5",
     "-3,1,-2",
     "-3,3,0",
     "-3,0,-3"})
  void test(final Double augend, final Double addend, final Double expectedResult) {

    final var augendExpression = mock(Expression.class);
    final var addendExpression = mock(Expression.class);

    when(calculator.calculate(augendExpression)).thenReturn(augend);
    when(calculator.calculate(addendExpression)).thenReturn(addend);

    final var plusExpression = new Plus(augendExpression, addendExpression);

    final var result = plusHandler.evaluate(calculator, plusExpression);

    assertThat(result).isCloseTo(expectedResult, Offset.offset(.1));
  }
}
