
package com.company.jasperreportsdemo.ui;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.jasperreportsdemo.business.ReportCreator;
import com.company.jasperreportsdemo.dal.EmployeeDAO;
import com.company.jasperreportsdemo.dal.OrderdetailDAO;
import com.company.jasperreportsdemo.dal.ProductDAO;
import com.company.jasperreportsdemo.entities.Employee;
import com.company.jasperreportsdemo.entities.Orderdetail;
import com.company.jasperreportsdemo.entities.Product;
import com.company.jasperreportsdemo.entities.queryObjects.ProductCategorySum;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.xdev.ui.XdevBrowserFrame;
import com.xdev.ui.XdevButton;
import com.xdev.ui.XdevGridLayout;
import com.xdev.ui.XdevHorizontalSplitPanel;
import com.xdev.ui.XdevVerticalLayout;
import com.xdev.ui.XdevView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class MainView extends XdevView {

	/**
	 * 
	 */
	public MainView() {
		super();
		this.initUI();
	}

	/**
	 * Event handler delegate method for the {@link XdevButton} {@link #button}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button_buttonClick(Button.ClickEvent event) {
		List<Employee> employeeList = new EmployeeDAO().findAll();
		JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(employeeList);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("creator", "Christian Kümmel");
		parameterMap.put("created", new Date());

		ReportCreator report = new ReportCreator();
		report.setDataSource(data);
		report.setParameterMap(parameterMap);
		report.setTemplatePath("WebContent/WEB-INF/resources/reports/Report 1 - Basic.jasper");

		try {
			browserFrame.setSource(report.getResource());
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #button2}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button2_buttonClick(Button.ClickEvent event) {
		List<Product> productList = new ProductDAO().getProductsOrderedByCategory();

		JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(productList);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("creator", "Christian Kümmel");
		parameterMap.put("created", new Date());

		ReportCreator report = new ReportCreator();
		report.setDataSource(data);
		report.setParameterMap(parameterMap);
		report.setTemplatePath("WebContent/WEB-INF/resources/reports/Report 2 - Group.jasper");

		try {
			browserFrame.setSource(report.getResource());
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #button3}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button3_buttonClick(Button.ClickEvent event) {
		List<Orderdetail> orderDetailList = new OrderdetailDAO().findAll();

		JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(orderDetailList);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("creator", "Christian Kümmel");
		parameterMap.put("created", new Date());

		ReportCreator report = new ReportCreator();
		report.setDataSource(data);
		report.setParameterMap(parameterMap);
		report.setTemplatePath("WebContent/WEB-INF/resources/reports/Report 3 - Crosstab" + ".jasper");

		try {
			browserFrame.setSource(report.getResource());
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #button5}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button5_buttonClick(Button.ClickEvent event) {
		List<ProductCategorySum> productsForChart = new ProductDAO().getProductsForChart();

		JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(productsForChart);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("creator", "Christian Kümmel");
		parameterMap.put("created", new Date());

		ReportCreator report = new ReportCreator();
		report.setDataSource(data);
		report.setParameterMap(parameterMap);
		report.setTemplatePath("WebContent/WEB-INF/resources/reports/Report 5 - Charts" + ".jasper");

		try {
			browserFrame.setSource(report.getResource());
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * WARNING: Do NOT edit!<br>The content of this method is always regenerated
	 * by the UI designer.
	 */
	// <generated-code name="initUI">
	private void initUI() {
		this.gridLayout = new XdevGridLayout();
		this.horizontalSplitPanel = new XdevHorizontalSplitPanel();
		this.verticalLayout = new XdevVerticalLayout();
		this.button = new XdevButton();
		this.button2 = new XdevButton();
		this.button3 = new XdevButton();
		this.button4 = new XdevButton();
		this.button5 = new XdevButton();
		this.button6 = new XdevButton();
		this.button7 = new XdevButton();
		this.button8 = new XdevButton();
		this.browserFrame = new XdevBrowserFrame();

		this.horizontalSplitPanel.setSplitPosition(30.0F, Unit.PERCENTAGE);
		this.verticalLayout.setMargin(new MarginInfo(false, true, false, false));
		this.button.setCaption("Report 1 - Basic");
		this.button2.setCaption("Report 2 - Group");
		this.button3.setCaption("Report 3 - Grid");
		this.button4.setCaption("Report 4 - Images");
		this.button5.setCaption("Report 5 - Charts");
		this.button6.setCaption("Report 6 - SubReports");
		this.button7.setCaption("Report 7 - Invoice");
		this.button8.setCaption("Report 8 - BarCode");

		this.button.setWidth(100, Unit.PERCENTAGE);
		this.button.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button);
		this.verticalLayout.setComponentAlignment(this.button, Alignment.MIDDLE_CENTER);
		this.button2.setWidth(100, Unit.PERCENTAGE);
		this.button2.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button2);
		this.verticalLayout.setComponentAlignment(this.button2, Alignment.MIDDLE_CENTER);
		this.button3.setWidth(100, Unit.PERCENTAGE);
		this.button3.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button3);
		this.verticalLayout.setComponentAlignment(this.button3, Alignment.MIDDLE_CENTER);
		this.button4.setWidth(100, Unit.PERCENTAGE);
		this.button4.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button4);
		this.verticalLayout.setComponentAlignment(this.button4, Alignment.MIDDLE_CENTER);
		this.button5.setWidth(100, Unit.PERCENTAGE);
		this.button5.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button5);
		this.verticalLayout.setComponentAlignment(this.button5, Alignment.MIDDLE_CENTER);
		this.button6.setWidth(100, Unit.PERCENTAGE);
		this.button6.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button6);
		this.verticalLayout.setComponentAlignment(this.button6, Alignment.MIDDLE_CENTER);
		this.button7.setWidth(100, Unit.PERCENTAGE);
		this.button7.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button7);
		this.verticalLayout.setComponentAlignment(this.button7, Alignment.MIDDLE_CENTER);
		this.button8.setWidth(100, Unit.PERCENTAGE);
		this.button8.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.button8);
		this.verticalLayout.setComponentAlignment(this.button8, Alignment.MIDDLE_CENTER);
		CustomComponent verticalLayout_spacer = new CustomComponent();
		verticalLayout_spacer.setSizeFull();
		this.verticalLayout.addComponent(verticalLayout_spacer);
		this.verticalLayout.setExpandRatio(verticalLayout_spacer, 1.0F);
		this.verticalLayout.setSizeFull();
		this.horizontalSplitPanel.setFirstComponent(this.verticalLayout);
		this.browserFrame.setSizeFull();
		this.horizontalSplitPanel.setSecondComponent(this.browserFrame);
		this.gridLayout.setColumns(1);
		this.gridLayout.setRows(1);
		this.horizontalSplitPanel.setSizeFull();
		this.gridLayout.addComponent(this.horizontalSplitPanel, 0, 0);
		this.gridLayout.setColumnExpandRatio(0, 100.0F);
		this.gridLayout.setRowExpandRatio(0, 100.0F);
		this.gridLayout.setSizeFull();
		this.setContent(this.gridLayout);
		this.setSizeFull();

		button.addClickListener(event -> this.button_buttonClick(event));
		button2.addClickListener(event -> this.button2_buttonClick(event));
		button3.addClickListener(event -> this.button3_buttonClick(event));
		button5.addClickListener(event -> this.button5_buttonClick(event));
	} // </generated-code>

	// <generated-code name="variables">
	private XdevButton button, button2, button3, button4, button5, button6, button7, button8;
	private XdevBrowserFrame browserFrame;
	private XdevGridLayout gridLayout;
	private XdevVerticalLayout verticalLayout;
	private XdevHorizontalSplitPanel horizontalSplitPanel; // </generated-code>

}
