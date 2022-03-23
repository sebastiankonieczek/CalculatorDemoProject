package org.sko.calculator.calculations;

import org.sko.calculator.Calculator;

public interface ExpressionHandler<T extends Expression> {

  double evaluate(Calculator calculator, T expression);
}
