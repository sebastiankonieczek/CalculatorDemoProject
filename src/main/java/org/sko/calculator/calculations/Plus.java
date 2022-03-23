package org.sko.calculator.calculations;

import java.math.BigDecimal;
import java.util.Arrays;

final class Plus
   implements Calculation
{
   @Override
   public BigDecimal perform(
      final BigDecimal... addenda )
   {
      return Arrays.stream( addenda ).reduce( BigDecimal.ZERO, BigDecimal::add );
   }
}
