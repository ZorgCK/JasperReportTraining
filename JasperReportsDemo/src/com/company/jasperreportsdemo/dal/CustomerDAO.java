
package com.company.jasperreportsdemo.dal;

import com.company.jasperreportsdemo.entities.Customer;
import com.xdev.dal.JPADAO;

/**
 * Home object for domain model class Customer.
 * 
 * @see Customer
 */
public class CustomerDAO extends JPADAO<Customer, String> {
	public CustomerDAO() {
		super(Customer.class);
	}
}