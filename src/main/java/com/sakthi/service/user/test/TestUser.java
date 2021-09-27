package com.sakthi.service.user.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("test")
public class TestUser implements UserGeneric {

	@Override
	public String info() {
		return "this is test user...";
	}

}
