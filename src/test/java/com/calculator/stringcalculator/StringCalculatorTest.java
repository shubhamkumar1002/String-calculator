package com.calculator.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


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

	@Test
	void allowsNewLineAsDelimiterAlongWithComma() {
		assertEquals(15, new StringCalculator().add("2\n5,8"));
		assertEquals(9, new StringCalculator().add("1,1\n7"));
	}

	@Test
	void allowCustomDelimiterDefinedInHeader(){
		assertEquals(25, new StringCalculator().add("//;\n12;13"));
	}
	@Test
	void allowCustomDelimiterDefinedInHeaderFailed(){
		assertNotEquals(1, new StringCalculator().add("//;\n12;13"));
	}
	@Test
	void allowCustomDelimiterDefinedInHeaderException(){
		assertNotEquals(25, new StringCalculator().add("//;\n12,13"));
	}
}
