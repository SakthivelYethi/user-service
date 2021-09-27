package com.sakthi.service.user.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("admin")
public class AdminUser implements UserGeneric {

	@Override
	public String info() {
		return "This is admin user...";
	}

}
