package com.lucaskalil.storify.entities.enums;

public enum AccessSettings {
    OWNER(1),
    MENBER(2),
    GUEST(3);

    private int code;

	private AccessSettings(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static AccessSettings valueOf(int code) {
		for (AccessSettings value : AccessSettings.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid AccessSettings code");
	}
}
