package com.lucaskalil.storify.entities.enums;

public enum ModifyAccessSettings {
    OWNER(1),
    MENBERS(2),
    PUBLIC(3);

    private int code;

	private ModifyAccessSettings(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static ModifyAccessSettings valueOf(int code) {
		for (ModifyAccessSettings value : ModifyAccessSettings.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ModifyAccessSettings code");
	}
}
