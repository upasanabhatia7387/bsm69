package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.StaticUtils;

@ExtendWith(MockitoExtension.class)
public class StaticUtilsTest {
	
	StaticUtils staticUtils;
	
	@BeforeEach
	public void init() {
		staticUtils = new StaticUtils();
	}
	
	@Test
	public void testPrivateMethod() {
		assertEquals(staticUtils.getTest("Hello"), "Hello Building");
	}
	
	@Test
	public void testPrivateMethod1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException
	,InvocationTargetException{
		//Reflection API -- It is mainly used to call private method and constructor from outside the class
		Method method =  StaticUtils.class.getDeclaredMethod("privateTest", String.class);
		method.setAccessible(true);
		StaticUtils staticUtils = new StaticUtils();
		String result = (String) method.invoke(staticUtils, "Hello");
		assertEquals(staticUtils.getTest("Hello"), "Hello Building");
	}
	@Test
	public void staticTest() {
		try(MockedStatic mockstatic = Mockito.mockStatic(StaticUtils.class)){ //try with resource added in java7
			mockstatic.when(StaticUtils::range).thenReturn("Welcome");
			assertEquals(staticUtils.range(), "Msg");
		}
		
		
	}

}
