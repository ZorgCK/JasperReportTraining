
package com.company.jasperreportsdemo.dal;

import com.company.jasperreportsdemo.entities.Shipper;
import com.xdev.dal.JPADAO;
import java.lang.Integer;

/**
 * Home object for domain model class Shipper.
 * 
 * @see Shipper
 */
public class ShipperDAO extends JPADAO<Shipper, Integer> {
	public ShipperDAO() {
		super(Shipper.class);
	}
}