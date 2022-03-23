package org.sko.calculator.calculations;

import java.math.BigDecimal;
import java.util.Arrays;

final class Minus
   implements Calculation
{
   @Override
   public BigDecimal perform( final BigDecimal... minuend )
   {
      if( minuend.length == 1 ) {
         return BigDecimal.ZERO.subtract( minuend[ 0 ] );
      }

      return Arrays.stream( minuend ).reduce( BigDecimal::subtract ).orElse( BigDecimal.ZERO );
   }
}
