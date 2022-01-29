package Enums;

public enum FileFormat {
    XLSX("xlsx"),
    XLS("xls"),
    UNDEFINED ("undefined");

    private final String typeFormat;

    FileFormat(String typeFormat) {
        this.typeFormat = typeFormat;
    }

    public String getTypeFormat() {
        return this.typeFormat;
    }

    static public FileFormat getType(String pType) {
        for (FileFormat typeFormat: FileFormat.values()) {
            if (typeFormat.getTypeFormat().equals(pType)) {
                return typeFormat;
            }
        }
        throw new RuntimeException("unknown type " + pType);
    }
}
