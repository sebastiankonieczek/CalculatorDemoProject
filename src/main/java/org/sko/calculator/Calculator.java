package org.sko.calculator;

import org.sko.calculator.calculations.Expression;
import org.sko.calculator.calculations.ExpressionHandlerProvider;

public final class Calculator {
  private final ExpressionHandlerProvider expressionHandlerProvider;

  public Calculator() {
    expressionHandlerProvider = new ExpressionHandlerProvider();
  }

  public double calculate(final Expression calculationExpression) {
    final var expressionHandler = expressionHandlerProvider.provider(calculationExpression);
    return expressionHandler.evaluate(this, calculationExpression);
  }
}
