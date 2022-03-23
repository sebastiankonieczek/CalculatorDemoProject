package org.sko.calculator.calculations;

import org.sko.calculator.Calculator;

final class MinusHandler implements ExpressionHandler<Minus> {

  @Override
  public double evaluate(final Calculator calculator, final Minus expression) {

    return calculator.calculate(expression.minuend())
        - calculator.calculate(expression.subtrahend());
  }
}
