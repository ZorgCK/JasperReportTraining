
package com.company.jasperreportsdemo.dal;

import com.xdev.dal.JPADAO;
import java.lang.Integer;
import com.company.jasperreportsdemo.entities.Supplier;

/**
 * Home object for domain model class Supplier.
 * 
 * @see Supplier
 */
public class SupplierDAO extends JPADAO<Supplier, Integer> {
	public SupplierDAO() {
		super(Supplier.class);
	}
}