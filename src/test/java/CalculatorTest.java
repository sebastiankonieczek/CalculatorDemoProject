import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sko.calculator.Calculator;
import org.sko.calculator.calculations.Expression;
import org.sko.calculator.calculations.ExpressionHandler;
import org.sko.calculator.calculations.ExpressionHandlerProvider;

class CalculatorTest {
  private Calculator calculator;
  private ExpressionHandlerProvider expressionHandlerProvider;

  @BeforeEach
  void setUp() {

    expressionHandlerProvider = mock(ExpressionHandlerProvider.class);
    calculator = new Calculator(expressionHandlerProvider);
  }

  @Test
  void test_calculator_evaluates_the_given_expression_on_the_respective_expression_handler() {

    final var expectedResult = 1.2d;

    final var expressionHandler = mock(ExpressionHandler.class);
    final var calculationExpression = mock(Expression.class);

    when(expressionHandlerProvider.provider(calculationExpression)).thenReturn(expressionHandler);
    when(expressionHandler.evaluate(calculator, calculationExpression)).thenReturn(expectedResult);

    final var result = calculator.calculate(calculationExpression);

    assertThat(result).isEqualTo(expectedResult);
  }
}
