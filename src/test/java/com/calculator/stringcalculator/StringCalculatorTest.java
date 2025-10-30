package com.calculator.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StringCalculatorTest {

	@Test
	void returnsZeroOnEmptyString() {
		assertEquals(0, new StringCalculator().add(""));
	}
	@Test
	void returnsValueOnSingleValue() {
		assertEquals(99, new StringCalculator().add("99"));
	}
	@Test
	void returnsTotalOfNumbersSeperatedByComma() {
		assertEquals(11, new StringCalculator().add("4,7"));
		assertEquals(49, new StringCalculator().add("9,15,25"));
	}

}
