package org.sko.calculator.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExpressionHandlerProviderTest {
  private final ExpressionHandlerProvider expressionHandlerProvider =
      new ExpressionHandlerProvider();

  public static Stream<Arguments> expressionHandlerFactoryTestData() {
    return Stream.of(
        Arguments.of(new Plus(v(), v()), PlusHandler.class),
        Arguments.of(new Minus(v(), v()), MinusHandler.class),
        Arguments.of(new Multiply(v(), v()), MultiplyHandler.class),
        Arguments.of(new Divide(v(), v()), DivideHandler.class),
        Arguments.of(v(), ValueHandler.class));
  }

  private static Value v() {
    return new Value(0);
  }

  @ParameterizedTest
  @MethodSource("expressionHandlerFactoryTestData")
  <T extends Expression> void test(
      final T expression, final Class<ExpressionHandler<T>> expressionHandlerClass) {

    final var expressionHandler = expressionHandlerProvider.provider(expression);
    assertThat(expressionHandler).isInstanceOf(expressionHandlerClass);
  }

  @Test
  void test_throws_exception_on_unknown_expression() {

    final Expression expression = mock(Expression.class);
    assertThatThrownBy(() -> expressionHandlerProvider.provider(expression))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
