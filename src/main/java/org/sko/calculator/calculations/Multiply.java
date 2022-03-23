package org.sko.calculator.calculations;

import java.math.BigDecimal;
import java.util.Arrays;

final class Multiply
   implements Calculation
{
   @Override
   public BigDecimal perform( final BigDecimal... operands )
   {
      if( operands.length == 0 ) {
         return BigDecimal.ZERO;
      }

      return Arrays.stream( operands ).reduce( BigDecimal.ONE, BigDecimal::multiply );
   }
}
