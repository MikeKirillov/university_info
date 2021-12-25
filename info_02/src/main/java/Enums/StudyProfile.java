package Enums;

public enum StudyProfile {
    ARCHITECTURE("Architecture"),
    DESIGN("Design"),
    ENGINEERING("Engineering"),
    ACCOUNTING("Accounting and finance"),
    BIOLOGY("Biology"),
    HEALTHCARE("Health and social care"),
    HISTORY("History"),
    MANAGEMENT("Business and management"),
    PHYSICS("Physics"),
    COMPUTER_SCIENCE("Computer science"),
    MATHEMATICS("Math"),
    JURISPRUDENCE("Law"),
    MEDICINE("Medicine"),
    LINGUISTICS("Linguistic");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
