# Software-Testing-Project

## Problem Description

**Problem Statement**: Mutation source code: Projects that use mutation testing,
based on mutation operators applied at the level of a statement within a
method or a function.

**Aim**: The mutated program needs to be strongly killed by the designed
test cases. At least three different mutation operators should be used.

## PITest Results
Link to PITest results: https://gsri30.github.io/Software-Testing-Project/

## Execution

### Pre-Setup Required

- Make sure to have Java JDK 11 successfully setup.
- Also make sure to have maven installed with proper PATH variables initialized.

### How to Run

Run the following command:

`mvn install`

`mvn test-compile org.pitest:pitest-maven:mutationCoverage`