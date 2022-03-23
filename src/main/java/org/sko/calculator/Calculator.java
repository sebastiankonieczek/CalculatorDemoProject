package org.sko.calculator;

import org.sko.calculator.calculations.Expression;
import org.sko.calculator.calculations.ExpressionHandlerProvider;

public class Calculator {
  private final ExpressionHandlerProvider expressionHandlerProvider;

  public Calculator(final ExpressionHandlerProvider expressionHandlerProvider) {
    this.expressionHandlerProvider = expressionHandlerProvider;
  }

  public double calculate(final Expression calculationExpression) {
    final var expressionHandler = expressionHandlerProvider.provide( calculationExpression);
    return expressionHandler.evaluate(this, calculationExpression);
  }
}
