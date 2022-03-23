package org.sko.calculator.calculations;

import org.sko.calculator.Calculator;

final class DivideHandler implements ExpressionHandler<Divide> {

  @Override
  public double evaluate(final Calculator calculator, final Divide expression) {
    final double divisor = calculator.calculate(expression.divisor());
    if (divisor == 0.0d) {
      throw new ArithmeticException("Division by zero");
    }

    return calculator.calculate(expression.dividend()) / divisor;
  }
}
