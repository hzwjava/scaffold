package com.rick.scaffold.service.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rick.scaffold.base.BaseTest;
import com.rick.scaffold.core.entity.user.Photo;
import com.rick.scaffold.core.service.user.PhotoService;

public class TestPhoto extends BaseTest{

	@Autowired
	private PhotoService ps;
	
	@Test
	public void testAddPhoto() {
		Photo p = new Photo();
		p.setSize(101);
		p.setUrl("baidu.com");
		p.setUserId("56077e0d6a8ad31d5fe33a63");
		ps.save(p);
	}
}