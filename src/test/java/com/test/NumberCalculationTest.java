package com.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.demo.NumberCalculation;

public class NumberCalculationTest {
	NumberCalculation nc;
	
	@BeforeEach
	void init() {
		nc=new NumberCalculation();
	}
	
	@Test
	void testAddition() {
		assertEquals(nc.add(10, 20), 30);
	}
	
	@Test
	void testAdd() {
		assertEquals(nc.add(10, 20), 30);
	}
	
	@Nested
	class AddTest{
		
		@Test
		void AddPositive() {
			assertEquals(nc.add(1, 1), 2);
		}
		
		@Test
		void addPositive_negative() {
			assertEquals(0, nc.add(1, -1));
		}
		
		@Test
		void AddNegative() {
			assertEquals(-2, nc.add(-1, -1));
		}
	}
	
	@Test
	void testMultiply() {
		assertAll(()-> assertEquals(0, nc.multiply(1, 0)),()->assertEquals(7, nc.multiply(7, 1)),
				()->assertEquals(20, nc.multiply(4, 5)));
	}
	
	
}
