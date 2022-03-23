package org.sko.calculator.calculations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValueHandlerTest {
  @ParameterizedTest
  @ValueSource(doubles = {2, -2, 0, -3})
  void test(final double value) {

    final var valueExpression = new Value(value);

    final var result = new ValueHandler().evaluate(null, valueExpression);

    assertThat(result).isEqualTo(value);
  }
}
