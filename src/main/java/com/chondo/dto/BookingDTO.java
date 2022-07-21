package com.chondo.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO extends AbstractDTO<BookingDTO> {
	private String code;

	private Date dateFrom;

	private Date dateTo;

	private Integer roomCount;

	private Integer adult;

	private Integer children;

	private String logs;

	private HotelDTO hotel;

	private RoomTypeDTO roomType;

	private Long userId;

	private CustomerDTO customer;

	private BookingStatusDTO status;

	private Long sellPriceBooked;

	private Long sellPriceUpgrade;

	private Long originalPriceBooked;

	private Long originalPriceUpgrade;

	private Long priceService;

	private Long priceServiceFree;

	private Long totalPrice;

	private Integer signed;

	private Long nightCount;

	private boolean refund;

	private List<BookedRoomDTO> bookedRooms = new ArrayList<BookedRoomDTO>();

	public String getSignature() {
		if (signed == null || signed == 0) {
			return "Chưa ký";
		} else if (signed == 1) {
			return "Dẫ ký";
		} else {
			return "Ký thất bại";
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}

	public Integer getAdult() {
		return adult;
	}

	public void setAdult(Integer adult) {
		this.adult = adult;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}

	public RoomTypeDTO getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeDTO roomType) {
		this.roomType = roomType;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BookingStatusDTO getStatus() {
		return status;
	}

	public void setStatus(BookingStatusDTO status) {
		this.status = status;
	}

	public List<BookedRoomDTO> getBookedRooms() {
		return bookedRooms;
	}

	public void setBookedRooms(List<BookedRoomDTO> bookedRooms) {
		this.bookedRooms = bookedRooms;
	}

	public String getLogs() {
		return logs;
	}

	public void setLogs(String logs) {
		this.logs = logs;
	}

	public Long getSellPriceBooked() {
		return sellPriceBooked;
	}

	public void setSellPriceBooked(Long sellPriceBooked) {
		this.sellPriceBooked = sellPriceBooked;
	}

	public Long getSellPriceUpgrade() {
		return sellPriceUpgrade;
	}

	public void setSellPriceUpgrade(Long sellPriceUpgrade) {
		this.sellPriceUpgrade = sellPriceUpgrade;
	}

	public Long getOriginalPriceBooked() {
		return originalPriceBooked;
	}

	public void setOriginalPriceBooked(Long originalPriceBooked) {
		this.originalPriceBooked = originalPriceBooked;
	}

	public Long getOriginalPriceUpgrade() {
		return originalPriceUpgrade;
	}

	public void setOriginalPriceUpgrade(Long originalPriceUpgrade) {
		this.originalPriceUpgrade = originalPriceUpgrade;
	}

	public Long getPriceService() {
		return priceService;
	}

	public void setPriceService(Long priceService) {
		this.priceService = priceService;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getNightCount() {
		return nightCount;
	}

	public void setNightCount(Long nightCount) {
		this.nightCount = nightCount;
	}

	public Integer getSigned() {
		return signed;
	}

	public void setSigned(Integer signed) {
		this.signed = signed;
	}

	public String toStringBooking() {
		StringBuilder toString = new StringBuilder();
		toString.append("Đặt phòng thành công!\n\nTHÔNG TIN ĐẶT PHÒNG:\n");
		toString.append("Mã đặt phòng:               " + getCode() + "\n");
		toString.append("Khách hàng:                 " + getCustomer().getFirstName() + " "
				+ getCustomer().getLastName() + "\n");
		toString.append("Loại phòng:                 " + getRoomType().getName() + "\n");
		toString.append("Ngày nhận phòng:            " + getDateFrom() + "\n");
		toString.append("Ngày trả phòng:             " + getDateTo() + "\n");
		toString.append("Số phòng:                   " + getRoomCount() + "\n");
		toString.append(
				"Số lượng:                   " + getAdult() + " người lớn, " + getChildren() + " trẻ em" + "\n");
		toString.append("Thời gian đặt phòng:        " + getCreatedDate());

		return toString.toString();
	}

	public String getInfo() {
		String createdDate = String.format("%2d:%2d %2d-%2d-%4d", getCreatedDate().getHours(),
				getCreatedDate().getMinutes(), getCreatedDate().getDay(), getCreatedDate().getMonth(),
				getCreatedDate().getYear() + 1900);

		return getCode() + getCustomer().getFirstName() + getCustomer().getLastName() + getRoomType().getName()
				+ getDateFrom() + getDateTo() + getRoomCount() + getAdult() + getChildren() + createdDate;
	}

	public boolean isRefund() {
		return refund;
	}

	public void setRefund(boolean refund) {
		this.refund = refund;
	}

	public Long getPriceServiceFree() {
		return priceServiceFree;
	}

	public void setPriceServiceFree(Long priceServiceFree) {
		this.priceServiceFree = priceServiceFree;
	}

}
