package com.lucaskalil.storify.entities.enums;

public enum FileFlag {
    IMAGE(1),
    VIDEO(2),
    DOCUMENT(3);

    private int code;

	private FileFlag(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static FileFlag valueOf(int code) {
		for (FileFlag value : FileFlag.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid FileFlag code");
	}
}
