package org.sko.calculator.calculations;

import java.math.BigDecimal;

public sealed interface Calculation
   permits Divide, Minus, Multiply, Plus
{
   BigDecimal perform( final BigDecimal... operands );
}
