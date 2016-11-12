
package com.company.jasperreportsdemo.dal;

import com.xdev.dal.JPADAO;
import com.company.jasperreportsdemo.entities.Order;
import java.lang.Integer;

/**
 * Home object for domain model class Order.
 * 
 * @see Order
 */
public class OrderDAO extends JPADAO<Order, Integer> {
	public OrderDAO() {
		super(Order.class);
	}
}