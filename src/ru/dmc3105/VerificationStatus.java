package ru.dmc3105;

public enum VerificationStatus {
    UNKNOWN("Неизвестно") ,
    VERIFIED("Подтверждено"),
    NON_VERIFIED("Не подтверждено"),
    ;

    private final String inRussian;

    VerificationStatus(String inRussian) {
        this.inRussian = inRussian;
    }

    //VerificationStatus.getInRussian(status);
    public static String getInRussian(VerificationStatus status) {
        return status.inRussian;
    }

    //status.getInRussian();
    public String getInRussian() {
        return inRussian;
    }

    public static VerificationStatus of(Boolean verified) {
        if (verified == null) {
            return UNKNOWN;
        }
        return verified ? VERIFIED : NON_VERIFIED;
    }

    @Override
    public String toString() {
        return getInRussian();
    }
}
