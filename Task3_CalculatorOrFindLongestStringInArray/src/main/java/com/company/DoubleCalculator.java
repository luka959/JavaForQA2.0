package com.company;

import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

/**
 * Реализуются функции сложения, вычитания, деления, умножения.
 *
 * @author Golovacheva Valeriya
 * @version 1.0
 */

public class DoubleCalculator {
    /**
     * Реализации допустимых операций.
     */
    private static final Map<Character, DoubleBinaryOperator> FUNCTIONS;

    static {
        Map<Character, DoubleBinaryOperator> tmpFunctions = new HashMap<>();
        tmpFunctions.put('+', Double::sum);
        tmpFunctions.put('-', (a, b) -> a - b);
        tmpFunctions.put('*', (a, b) -> a * b);
        tmpFunctions.put('/', (a, b) -> a / b);
        FUNCTIONS = Collections.unmodifiableMap(tmpFunctions);
    }

    private final Scanner scanner;
    private final PrintStream out;

    /**
     * Создание нового калькулятора.
     *
     * @param scanner поток ввода данных.
     * @param out     поток вывода данных.
     */
    public DoubleCalculator(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    public static void main(String[] args) {
        DoubleCalculator calculator = new DoubleCalculator(new Scanner(System.in), System.out);
        calculator.calculate();
    }

    /**
     * Запуск калькулятора.
     */
    public void calculate() {
        char operation;
        while (true) {
            try {
                operation = enterOperation();
                break;
            } catch (IllegalOperationException e) {
                e.printStackTrace();
            }
        }

        double firstValue = enterDoubleValue();
        double secondValue = enterDoubleValue();
        double result = calculate(operation, firstValue, secondValue);
        out.printf("%.4f %c %.4f = %.4f", firstValue, operation, secondValue, result);
    }

    /**
     * Ввод допустимого значения операции.
     *
     * @return символ операции
     */
    private char enterOperation() throws IllegalOperationException {
        while (true) {
            out.println("Введите операцию, допустимые значения: " + FUNCTIONS.keySet());
            scanner.skip(".*\\n");
            String next = scanner.next();
            char operation = next.charAt(0);
            if (FUNCTIONS.containsKey(operation)) {
                return operation;
            } else throw new IllegalOperationException();
        }
    }

    /**
     * Ввод дробного числа.
     *
     * @return дробное число
     */
    private double enterDoubleValue() {
        while (true) {
            out.println("Введите число:");
            scanner.skip(".*\\n");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
        }
    }

    /**
     * Выполнения заданной операции.
     *
     * @param operation операция
     * @param a         первый аргумент операции
     * @param b         второй аргумент операции
     * @return результат выполнения операции
     */
    public static double calculate(char operation, double a, double b) {
        return FUNCTIONS.get(operation).applyAsDouble(a, b);
    }
}
