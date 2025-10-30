package com.calculator.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
	void throwsExceptionOnNegativeNumbers(){
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			new StringCalculator().add("1, -2, 3, -4");
		});
		assertEquals("negatives not allowed [-2, -4]", e.getMessage());
	}

	@Test
	void trackAddMethodInvokedCalls() {
		StringCalculator sc = new StringCalculator();
		sc.add("34, 66");
		sc.add("24, 26");
		sc.add("14, 16");
		assertEquals(3, sc.getAddCounter());
	}

	@Test
	void numberGreaterThanThousandIgnored() {
		assertEquals(1, new StringCalculator().add("1,1001"));
		assertEquals(1001, new StringCalculator().add("1,1000"));
	}
}
