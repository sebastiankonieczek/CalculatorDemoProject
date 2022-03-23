# Calculator Demo Project

## Abstract

This is a simple calculator that takes an arithmetic expression and returns the numeric value of
evaluating that expression.

Arithmetic expressions are represented as trees nested operators and operands. E.g. the expression 2

+ 3 would be represented by the graph below.

```
    ┌─┐     
    │+│     
    └─┘     
 ┌───┴───┐ 
 ▼       ▼ 
┌─┐     ┌─┐
│2│     │3│
└─┘     └─┘
```

Analogously, 2 * 3 + 4 would be represented as, taking operator precedences into account:

```
        ┌─┐    
        │+│    
        └─┘    
     ┌───┴───┐ 
     ▼       ▼ 
    ┌─┐     ┌─┐
    │*│     │4│
    └─┘     └─┘
 ┌───┴───┐     
 ▼       ▼     
┌─┐     ┌─┐    
│2│     │3│    
└─┘     └─┘
```

Evaluation consists of a depth-first traversal of the graph in order to evaluate the operations.
Supported nodes are `Minus`, `Multiply`, `Divide`, `Plus` and `Value`. The leaves of the graph
should always be values. If you are familiar with interpreters, this should remind you of a very
simple AST (abstract syntax tree) interpreter.

## Intention

The intention of this simple calculator project is to serve as a showcase to compare two different
approaches to testing a component with a well-defined api.

- The first approach is to test all inherent business logic only through the public api.
- The second approach is to test all subcomponents of the component and finally only testing that
  the public api combines subcomponents as desired.

### Note

This is just a demo project. The code in here is in no way complete or failsafe as you can for
example easily produce an endless loop. Please do not consider using this in productive code. 
