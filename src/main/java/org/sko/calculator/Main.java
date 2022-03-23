package org.sko.calculator;

import org.sko.calculator.calculations.ExpressionHandlerProvider;
import org.sko.calculator.calculations.Minus;
import org.sko.calculator.calculations.Plus;
import org.sko.calculator.calculations.Value;

public class Main {
  public static void main(final String[] args) {

    final var calculator = new Calculator(new ExpressionHandlerProvider());

    final var minuend = new Plus(new Value(10d), new Value(20d));
    final var subtrahend = new Plus(new Value(3d), new Value(4d));
    final var calculationExpression = new Minus(minuend, subtrahend);

    final var result = calculator.calculate(calculationExpression);

    System.out.println(result);
  }
}
