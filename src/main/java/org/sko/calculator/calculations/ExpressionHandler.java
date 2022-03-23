package org.sko.calculator.calculations;

import org.sko.calculator.Calculator;

public sealed interface ExpressionHandler< T extends Expression >
   permits PlusHandler, MinusHandler, MultiplyHandler, DivideHandler, ValueHandler {

   double evaluate( Calculator calculator, T expression );
}
