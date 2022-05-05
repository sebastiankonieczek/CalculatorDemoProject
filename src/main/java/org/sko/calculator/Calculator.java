package org.sko.calculator;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.sko.calculator.calculations.CalculationFactory;

public class Calculator {
    private final CalculationFactory calculationFactory;

    public Calculator(CalculationFactory calculationFactory) {
        this.calculationFactory = calculationFactory;
    }

    public BigDecimal calculate(final Collection<Operation> operations) {
        return calculate(Objects.requireNonNullElse(operations, List.of()), Operator.PLUS);
    }

    private BigDecimal calculate(
            final Collection<Operation> operations,
            final Operator operator) {
        if (operator == null) {
            return BigDecimal.ZERO;
        }

        final var bigDecimals =
                operations.stream()
                        .map(this::performCalculation)
                        .toArray(BigDecimal[]::new);

        return calculationFactory.create(operator).perform(bigDecimals);
    }

    private BigDecimal performCalculation(final Operation operation) {
        if (operation.nestedOperations() == null || operation.nestedOperations().isEmpty()) {
            final var calculation = calculationFactory.create(operation.operator());
            return calculation.perform(operation.operandA(), operation.operandB());
        }

        return calculate(Stream.concat(Stream.of(Operation.of(operation.operator(),
                                        operation.operandA(),
                                        operation.operandB())),
                                operation.nestedOperations().stream())
                        .toList(),
                operation.nestedOperationsOperator());
    }
}
