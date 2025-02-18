package com.zogg.zoggservice.enums;

import lombok.Getter;

@Getter
public enum Language {
    ENGLISH("English"),
    KANNADA("ಕನ್ನಡ"),
    HINDI("हिंदी"),
    TELUGU("తెలుగు");

    private final String displayName;

    Language(String displayName) {
        this.displayName = displayName;
    }

}
