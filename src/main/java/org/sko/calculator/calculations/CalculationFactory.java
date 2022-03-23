package org.sko.calculator.calculations;

import java.util.Map;
import org.sko.calculator.Operator;

public class CalculationFactory
{
   private static final Map< Operator, Calculation > calculations = Map.of( Operator.PLUS,
                                                                            new Plus(),
                                                                            Operator.MINUS,
                                                                            new Minus(),
                                                                            Operator.MULTIPLY,
                                                                            new Multiply(),
                                                                            Operator.DIVIDE,
                                                                            new Divide() );

   public Calculation create( final Operator operator )
   {
      return calculations.get( operator );
   }
}
