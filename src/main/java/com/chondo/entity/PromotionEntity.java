package com.chondo.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "promotions")
public class PromotionEntity extends BaseEntity {
	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private Integer value;
	
	@Column
	private String description;
	
	@Column(name = "date_begin")
	private Date dateBegin;
	
	@Column(name = "date_end")
	private Date dateEnd;
	
	@OneToMany(mappedBy = "promotion")
	private List<RoomTypeEntity> roomTypes = new ArrayList<RoomTypeEntity>();

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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public List<RoomTypeEntity> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<RoomTypeEntity> roomTypes) {
		this.roomTypes = roomTypes;
	}
	
	
}
