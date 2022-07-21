package com.chondo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "staff_status")
public class StaffStatusEntity extends BaseEntity{
	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Integer active;
	
	@Column
	private String btnStyle;
	
	@OneToMany(mappedBy = "status")
    private List<StaffEntity> staffs = new ArrayList<StaffEntity>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public List<StaffEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffEntity> staffs) {
		this.staffs = staffs;
	}

	public String getBtnStyle() {
		return btnStyle;
	}

	public void setBtnStyle(String btnStyle) {
		this.btnStyle = btnStyle;
	}
	
	
}
