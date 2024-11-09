package com.lucaskalil.storify.entities.enums;

public enum FileType {
    JPEG(1, FileFlag.IMAGE), // Image Types
    JPG(2, FileFlag.IMAGE),  // ||
	PNG(3, FileFlag.IMAGE),  // ||
	GIF(4, FileFlag.IMAGE),  // ||
	BMP(5, FileFlag.IMAGE),  // ||
	TIFF(6, FileFlag.IMAGE), // ||
	SVG(7, FileFlag.IMAGE),  // ||
	WEBP(8, FileFlag.IMAGE), // ||

    MP4(9, FileFlag.VIDEO),   // Video Types
    AVI(10, FileFlag.VIDEO),  // ||
    MKV(11, FileFlag.VIDEO),  // ||
    MOV(12, FileFlag.VIDEO),  // ||
    WMV(13, FileFlag.VIDEO),  // ||
    FLV(14, FileFlag.VIDEO),  // ||
    WEBM(15, FileFlag.VIDEO), // ||

    PDF(16, FileFlag.DOCUMENT),  // Document Types
    DOC(17, FileFlag.DOCUMENT),  // ||
    DOCX(18, FileFlag.DOCUMENT), // ||
    TXT(19, FileFlag.DOCUMENT),  // ||
    ODT(20, FileFlag.DOCUMENT),  // ||
    RTF(21, FileFlag.DOCUMENT),  // ||
    HTML(22, FileFlag.DOCUMENT), // ||
    HTM(23, FileFlag.DOCUMENT),  // ||
    XLS(24, FileFlag.DOCUMENT),  // ||
    XLSX(25, FileFlag.DOCUMENT), // ||
    PPT(26, FileFlag.DOCUMENT),  // ||
    PPTX(27, FileFlag.DOCUMENT); // ||

	private int code;
    private FileFlag flag;

	private FileType(int code, FileFlag flag) {
		this.code = code;
        this.flag = flag;
	}

	public int getCode() {
		return code;
	}

    public FileFlag getFlag() {
        return flag;
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
