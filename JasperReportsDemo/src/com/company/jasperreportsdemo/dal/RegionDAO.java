
package com.company.jasperreportsdemo.dal;

import com.xdev.dal.JPADAO;
import com.company.jasperreportsdemo.entities.Region;

/**
 * Home object for domain model class Region.
 * 
 * @see Region
 */
public class RegionDAO extends JPADAO<Region, Integer> {
	public RegionDAO() {
		super(Region.class);
	}
}