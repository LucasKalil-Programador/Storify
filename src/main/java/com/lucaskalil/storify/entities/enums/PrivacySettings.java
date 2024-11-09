package com.lucaskalil.storify.entities.enums;

public enum PrivacySettings {
    PRIVATE(1),
    PUBLIC(2),
    INVITATION(3);

    private int code;

	private PrivacySettings(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PrivacySettings valueOf(int code) {
		for (PrivacySettings value : PrivacySettings.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PrivacySettings code");
	}
}
