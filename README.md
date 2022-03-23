# Calculator demo project

## Abstract

This is a simple calculator that takes a list of operations and executes them, adding up the result of each single operation. An
operation therefore consists of an Operator(PLUS,MINUS,MULTIPLY,DIVIDE) and two operands(BigDecimal).

An operation also may contain a List of nested operations with a specific operator to combine these operations as well as the
result with the base operation.

So an operation `Operation(PLUS, 10, 20, (Operation(PLUS, 3, 4)), MINUS)` will result into the following formula:
`(10+20)-(3+4)` and therefore in the result of `23`.

## Intention

This is a demo project to show two approaches of testing a very specific Library with a well-defined api.

The first approach is to test all inherent business logic only through the public api.

The second approach is to test all subcomponents of the library and finally only testing that the public api combines subcomponent
as desired.

### note

This is just a demo project. The code in here is in no way complete or failsafe as you can for example easily produce an endless
loop. Please do not consider using this in productive code. 
