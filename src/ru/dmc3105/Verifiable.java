package ru.dmc3105;

public interface Verifiable {
    default VerificationStatus verify()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default VerificationStatus getStatus()
    {
        return VerificationStatus.UNKNOWN;
    }

    default boolean isVerified()
    {
        return false;
    }
}
