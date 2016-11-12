package com.company.jasperreportsdemo.business;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.jasperreportsdemo.ui.MainView;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.xdev.res.ApplicationResource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportCreator {

	private static final Logger logger = LoggerFactory.getLogger(MainView.class);
	private StreamResource resource;
	private static final String CLOUD_MANAGER_WAR_UPLOAD_FILE_DIRECTORY = System.getProperty("java.io.tmpdir");
	private JRBeanCollectionDataSource dataSource;
	private String templatePath;
	private Map<String, Object> parameterMap;

	
	public JRBeanCollectionDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(JRBeanCollectionDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public Map<String, Object> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, Object> parameterMap) {
		this.parameterMap = parameterMap;
	}

	private StreamResource loadAndFillReport() throws JRException, IOException {
		JasperReport report = (JasperReport) JRLoader.loadObject(
//				new ApplicationResource(this.getClass(), "WebContent/WEB-INF/resources/reports/Report 1 - Basic.jasper")
				new ApplicationResource(this.getClass(), this.getTemplatePath())
						.getStream().getStream());

		StreamResource.StreamSource source = new StreamSource() {
			@Override
			public InputStream getStream() {
				byte[] b = null;

				try {

					b = JasperRunManager.runReportToPdf(report, parameterMap, dataSource);
				} catch (JRException ex) {
					System.out.println(ex);
					logger.info("Logger:" + ex.getMessage());
				}

				return new ByteArrayInputStream(b);
			}
		};

		this.resource = new StreamResource(source,
				getTempPath() + File.separator + "myreport_" + System.currentTimeMillis() + ".pdf");
		this.resource.setMIMEType("application/pdf");
		return resource;

	}

	public static String getTempPath() throws IOException {
		Path tempDir = Files.createDirectories(Paths.get(CLOUD_MANAGER_WAR_UPLOAD_FILE_DIRECTORY));
		return tempDir.toAbsolutePath().toString();
	}

	public StreamResource getResource() throws JRException, IOException {

		return loadAndFillReport();
	}
}
