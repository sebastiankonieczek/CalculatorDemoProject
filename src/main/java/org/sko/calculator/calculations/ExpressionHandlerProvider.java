package org.sko.calculator.calculations;

public class ExpressionHandlerProvider {

   private static final DivideHandler DIVIDE_HANDLER = new DivideHandler();
   private static final PlusHandler PLUS_HANDLER = new PlusHandler();
   private static final MinusHandler MINUS_HANDLER = new MinusHandler();
   private static final MultiplyHandler MULTIPLY_HANDLER = new MultiplyHandler();
   private static final ValueHandler VALUE_HANDLER = new ValueHandler();

   public <T extends Expression> ExpressionHandler<T> provider(final T expression) {

      return switch( expression ) {
         case Plus plus -> (ExpressionHandler<T>)PLUS_HANDLER;
         case Minus minus -> (ExpressionHandler<T>)MINUS_HANDLER;
         case Multiply multiply -> (ExpressionHandler<T>)MULTIPLY_HANDLER;
         case Divide divide -> (ExpressionHandler<T>)DIVIDE_HANDLER;
         case Value value -> (ExpressionHandler<T>)VALUE_HANDLER;
         default -> throw new IllegalArgumentException("Unknown expression: " + expression.getClass());
      };
   }
}
