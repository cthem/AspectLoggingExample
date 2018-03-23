package com.aspect.jpa.test.integration;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;

import com.aspects.jpa.beans.CourseBean;
import com.aspects.jpa.beans.SchoolBean;
import com.aspects.jpa.beans.StudentBean;

public class LogginTest {
	
	@EJB
	StudentBean studentBean;
	
	@EJB
	SchoolBean schoolBean;
	
	@EJB
	CourseBean courseBean;

	@Deployment
	public static WebArchive createDeployment() throws IOException{
		WebArchive archive = MyDeployment.getWar();
		archive.addClass(MyDeployment.class);
		return archive;
	}
	
	@Test
	public void test() {
		assertEquals("hi","hi");
	}

}
