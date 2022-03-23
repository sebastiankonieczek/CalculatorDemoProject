import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sko.calculator.Calculator;
import org.sko.calculator.calculations.Divide;
import org.sko.calculator.calculations.Expression;
import org.sko.calculator.calculations.Minus;
import org.sko.calculator.calculations.Multiply;
import org.sko.calculator.calculations.Plus;
import org.sko.calculator.calculations.Value;

class TestCalculator {

  private static final double OFFSET = 0.1;

  private final Calculator calculator = new Calculator();

  public static Stream<Arguments> source() {
    return Stream.of(
        Arguments.of(new Plus(v(2d), v(3d)), 5d),
        Arguments.of(new Plus(v(-3d), v(1d)), -2d),
        Arguments.of(new Plus(v(-3d), v(3d)), 0d),
        Arguments.of(new Plus(v(-3d), v(0d)), -3d),
        Arguments.of(new Minus(v(2d), v(3d)), -1d),
        Arguments.of(new Minus(v(7.1), v(3d)), 4.1),
        Arguments.of(new Minus(v(-2d), v(-3d)), 1d),
        Arguments.of(new Minus(v(-3d), v(0d)), -3d),
        Arguments.of(new Multiply(v(2d), v(3d)), 6d),
        Arguments.of(new Multiply(v(7.1), v(3d)), 21.3),
        Arguments.of(new Multiply(v(0d), v(-3d)), 0d),
        Arguments.of(new Multiply(v(-2d), v(1d)), -2d),
        Arguments.of(new Divide(v(6d), v(3d)), 2d),
        Arguments.of(new Divide(v(7.1), v(1d)), 7.1),
        Arguments.of(new Divide(v(0d), v(-3d)), 0d),
        Arguments.of(new Divide(v(-4d), v(2d)), -2d),
        Arguments.of(
            new Minus(new Plus(v(2), new Multiply(v(-3), v(-3.3))), new Divide(v(7.1d), v(2d))),
            8.3d));
  }

  @ParameterizedTest
  @MethodSource("source")
  void testSimpleAddition(final Expression expression, final double expectedResult) {
    assertThat(calculator.calculate(expression)).isCloseTo(expectedResult, Offset.offset(OFFSET));
  }

  @Test
  void testDivisionByZero() {
    assertThatThrownBy(() -> calculator.calculate(new Divide(v(1), v(0))))
        .isInstanceOf(ArithmeticException.class)
        .hasMessage("Division by zero");
  }

  private static Value v(final double v) {
    return new Value(v);
  }
}
