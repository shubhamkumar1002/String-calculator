package com.calculator.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StringCalculatorTest {

	@Test
	void returnsZeroOnEmptyString() {
		assertEquals(0, new StringCalculator().add(""));
	}

}
