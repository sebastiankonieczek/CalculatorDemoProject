package org.sko.calculator.calculations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

final class Divide
   implements Calculation
{
   @Override
   public BigDecimal perform( final BigDecimal... operands )
   {
      if( operands.length == 1 ) {
         return BigDecimal.ONE.divide( operands[ 0 ], MathContext.DECIMAL128 );
      }

      return Arrays.stream( operands ).reduce( BigDecimal::divide ).orElse( BigDecimal.ZERO );
   }
}
