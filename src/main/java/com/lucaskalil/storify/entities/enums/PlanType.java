package com.lucaskalil.storify.entities.enums;

public enum PlanType {
    DEFAULT(1),
    BASIC(2),
    PREMIUM(3);

    private int code;

	private PlanType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PlanType valueOf(int code) {
		for (PlanType value : PlanType.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PlanType code");
	}
}
