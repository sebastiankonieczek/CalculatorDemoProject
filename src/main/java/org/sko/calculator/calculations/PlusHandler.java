package org.sko.calculator.calculations;

import org.sko.calculator.Calculator;

final class PlusHandler implements ExpressionHandler<Plus> {
  @Override
  public double evaluate(final Calculator calculator, final Plus expression) {

    return calculator.calculate(expression.augend()) + calculator.calculate(expression.addend());
  }
}
