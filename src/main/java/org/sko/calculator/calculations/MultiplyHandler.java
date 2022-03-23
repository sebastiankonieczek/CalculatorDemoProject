package org.sko.calculator.calculations;

import org.sko.calculator.Calculator;

final class MultiplyHandler implements ExpressionHandler<Multiply> {

  @Override
  public double evaluate(final Calculator calculator, final Multiply expression) {

    return calculator.calculate(expression.multiplier())
        * calculator.calculate(expression.multiplicand());
  }
}
