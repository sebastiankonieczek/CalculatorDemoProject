package org.sko.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.sko.calculator.calculations.CalculationFactory;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(new CalculationFactory());
    }

    @ParameterizedTest
    @CsvSource({
            "PLUS, 0,0,0",
            "PLUS, 1,1,2",
            "PLUS, 1,-1, 0",
            "PLUS, -10, -7, -17",
            "PLUS, 100, 100, 200",
            "MINUS, 0, 0, 0",
            "MINUS, 1, 1, 0",
            "MINUS, 4, 1, 3",
            "MINUS, -1, -1, 0",
            "MINUS, -10, -7, -3",
            "MINUS, 100, 50, 50",
            "DIVIDE, 100, 2, 50",
            "DIVIDE, 21, 7, 3",
            "DIVIDE, -1, -2, 0.5",
            "MULTIPLY, 0, 99, 0",
            "MULTIPLY, 1, 99, 99",
            "MULTIPLY, -3, 2, -6",
            "MULTIPLY, -3, -2, 6",
    })
    void test_simple_operations(Operator op, BigDecimal left, BigDecimal right, BigDecimal expectation) {
        final var result = calculator.calculate(List.of(Operation.of(op, left, right)));
        assertThat(result).isEqualByComparingTo(expectation);
    }

    @Test
    void test_division_by_zero() {
        final var division = Operation.of(Operator.DIVIDE, BigDecimal.ONE, BigDecimal.ZERO);
        assertThatThrownBy(() -> calculator.calculate(List.of(division)))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void test_nested_evaluation() {
        final var operation = new Operation(
                Operator.MULTIPLY, BigDecimal.valueOf(2), BigDecimal.ONE,
                List.of(Operation.of(Operator.PLUS, BigDecimal.ONE, BigDecimal.TEN)), Operator.PLUS);
        assertThat(calculator.calculate(List.of(operation))).isEqualTo(BigDecimal.valueOf(13));
    }

    @Test
    void test_chained_evaluation() {
        var operations = List.of(
                Operation.of(Operator.PLUS, BigDecimal.ONE, BigDecimal.ONE),
                Operation.of(Operator.MULTIPLY, BigDecimal.valueOf(2), BigDecimal.valueOf(3)),
                Operation.of(Operator.MINUS, BigDecimal.valueOf(7), BigDecimal.valueOf(-7))
        );
        assertThat(calculator.calculate(operations)).isEqualTo(BigDecimal.valueOf(22));

    }
}