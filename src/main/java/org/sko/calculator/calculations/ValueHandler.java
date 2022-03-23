package org.sko.calculator.calculations;

import org.sko.calculator.Calculator;

final class ValueHandler implements ExpressionHandler<Value> {
  @Override
  public double evaluate(final Calculator ignored, final Value expression) {

    return expression.value();
  }
}
