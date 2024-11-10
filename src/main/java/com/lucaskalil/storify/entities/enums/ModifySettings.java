package com.lucaskalil.storify.entities.enums;

public enum ModifySettings {
    OWNER(1),
    MENBERS(2),
    PUBLIC(3);

    private int code;

	private ModifySettings(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static ModifySettings valueOf(int code) {
		for (ModifySettings value : ModifySettings.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ModifySettings code");
	}
}
