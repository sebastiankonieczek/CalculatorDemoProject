package org.sko.calculator;

import java.math.BigDecimal;
import java.util.Collection;

public record Operation( Operator operator,
                         BigDecimal operandA,
                         BigDecimal operandB,
                         Collection< Operation > nestedOperations,
                         Operator nestedOperationsOperator )
{
   public static Operation of(
      final Operator operator,
      final BigDecimal operandA,
      final BigDecimal operandB )
   {
      return new Operation( operator, operandA, operandB, null, null );
   }
}
