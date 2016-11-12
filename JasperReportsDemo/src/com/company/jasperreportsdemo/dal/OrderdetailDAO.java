
package com.company.jasperreportsdemo.dal;

import com.company.jasperreportsdemo.entities.Orderdetail;
import com.xdev.dal.JPADAO;
import com.company.jasperreportsdemo.entities.OrderdetailId;

/**
 * Home object for domain model class Orderdetail.
 * 
 * @see Orderdetail
 */
public class OrderdetailDAO extends JPADAO<Orderdetail, OrderdetailId> {
	public OrderdetailDAO() {
		super(Orderdetail.class);
	}
}