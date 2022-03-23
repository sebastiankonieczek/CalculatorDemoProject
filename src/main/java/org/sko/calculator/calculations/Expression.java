package org.sko.calculator.calculations;

public sealed interface Expression permits Plus, Minus, Multiply, Divide, Value {
}
