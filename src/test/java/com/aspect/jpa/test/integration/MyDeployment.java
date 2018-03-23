package com.aspect.jpa.test.integration;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class MyDeployment {

	public static WebArchive getWar() {
		return ShrinkWrap.create(WebArchive.class)
				.addPackages(true, "com.aspect.jpa")
				.addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies()
						 .resolve().withTransitivity().asFile())
	            .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
	}

	public static JavaArchive getJar() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackages(true, "com.gnt.sbn")
	            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}
