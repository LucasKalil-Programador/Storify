package com.lucaskalil.storify.entities.enums;

public enum UserStatus {
    NO_PROBLEMS(1),
	SUSPENDED(2),
	BANNED(3),
	CLOSED(4);

	private int code;

	private UserStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static UserStatus valueOf(int code) {
		for (UserStatus value : UserStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid UserStatus code");
	}
}
