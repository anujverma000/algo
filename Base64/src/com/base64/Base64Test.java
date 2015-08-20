package com.base64;

import static org.junit.Assert.*;

import org.junit.Test;

public class Base64Test {

	/**
	 * Positive test 
	 */
	@Test
	public void testAnuj() {
		assertEquals(Base64.encodeBase64("ANUJ"), "QU5VSg==");
	}
	
	/**
	 * Negative test 
	 */
	@Test
	public void testA() {
		assertNotEquals(Base64.encodeBase64("A"), "=");
	}


}
