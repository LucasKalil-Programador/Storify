package com.lucaskalil.storify.entities.enums;

public enum FileType {
    JPEG(1), // Image Types
    JPG(2),  // ||
	PNG(3),  // ||
	GIF(4),  // ||
	BMP(5),  // ||
	TIFF(6), // ||
	SVG(7),  // ||
	WEBP(8), // ||

    MP4(9),   // Video Types
    AVI(10),  // ||
    MKV(11),  // ||
    MOV(12),  // ||
    WMV(13),  // ||
    FLV(14),  // ||
    WEBM(15), // ||

    PDF(16),  // Document Types
    DOC(17),  // ||
    DOCX(18), // ||
    TXT(19),  // ||
    ODT(20),  // ||
    RTF(21),  // ||
    HTML(22), // ||
    HTM(23),  // ||
    XLS(24),  // ||
    XLSX(25), // ||
    PPT(26),  // ||
    PPTX(27); // ||

	private int code;

	private FileType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static FileType valueOf(int code) {
		for (FileType value : FileType.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid FileType code");
	}
}
