package org.springframework.samples.petportal;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class MavenDependencyOrderingTest extends TestCase {

	@Test
	public void testOrdering() {

		String basePath = "/develop/workspace/jetexpress/ordering";

		try {
			List<String> dependencies = FileUtils.readLines(new File(basePath + File.separator + "jetexpress-dependencies.txt"));
			List<String> properties = FileUtils.readLines(new File(basePath + File.separator + "jetexpress-properties.txt"));

			String dependenciesInSingleLine = StringUtils.join(dependencies, "");
			dependenciesInSingleLine = dependenciesInSingleLine.replace("		", "");
			dependenciesInSingleLine = dependenciesInSingleLine.replace("	", "");
			dependenciesInSingleLine = dependenciesInSingleLine.replace("</dependency>", "</dependency>;");


			String[] dependencyLines = dependenciesInSingleLine.split(";");
			
			List<String> dependlines =  Arrays.asList(dependencyLines);

			File dependenciesOutXml = new File(basePath + File.separator + "jetexpress-dependencies.xml");
			dependenciesOutXml.delete();
			dependenciesOutXml.createNewFile();

			File propertiesOutXml = new File(basePath + File.separator + "jetexpress-properties.xml");

			propertiesOutXml.delete();
			propertiesOutXml.createNewFile();

			Collections.sort(properties);
			FileUtils.writeLines(propertiesOutXml, "utf-8", properties, IOUtils.LINE_SEPARATOR);

			Collections.sort(dependlines);
			FileUtils.writeLines(dependenciesOutXml, "utf-8", dependlines, IOUtils.LINE_SEPARATOR);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
