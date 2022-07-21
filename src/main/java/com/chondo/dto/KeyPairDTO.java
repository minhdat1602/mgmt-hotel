package com.chondo.dto;

public class KeyPairDTO extends AbstractDTO<KeyPairDTO> {
	private Long id;
	private String privateKey;
	private String publicKey;
	private Integer active;

	public String getStatus() {
		return active == 1 ? "Bật" : "Tắt";
	}
	
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
