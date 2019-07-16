package com.capgemini.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBConnectionTest {

	@Test
	void testGetConnection() {
	assertNotNull(DBconnection.getConnection());
		
	}

}
