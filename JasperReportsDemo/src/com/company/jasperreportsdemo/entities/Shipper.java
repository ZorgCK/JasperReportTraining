package com.company.jasperreportsdemo.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.company.jasperreportsdemo.dal.ShipperDAO;
import com.xdev.dal.DAO;
import com.xdev.util.Caption;

/**
 * Shipper
 */
@DAO(daoClass = ShipperDAO.class)
@Caption("{%companyname}")
@Entity
@Table(name = "SHIPPERS", schema = "PUBLIC", catalog = "NORTHWIND")
public class Shipper implements java.io.Serializable {

	private Integer shipperid;
	private String companyname;
	private String phone;
	private Set<Order> orders = new HashSet<Order>(0);

	public Shipper() {
	}

	public Shipper(String companyname) {
		this.companyname = companyname;
	}

	public Shipper(String companyname, String phone, Set<Order> orders) {
		this.companyname = companyname;
		this.phone = phone;
		this.orders = orders;
	}

	@Caption("Shipperid")
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "SHIPPERID", unique = true, nullable = false, columnDefinition = "INTEGER")
	public Integer getShipperid() {
		return this.shipperid;
	}

	public void setShipperid(Integer shipperid) {
		this.shipperid = shipperid;
	}

	@Caption("Companyname")
	@Column(name = "COMPANYNAME", nullable = false, columnDefinition = "VARCHAR", length = 40)
	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	@Caption("Phone")
	@Column(name = "PHONE", columnDefinition = "VARCHAR", length = 24)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Caption("Orders")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipper")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
