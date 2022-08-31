package com.example.noorehuda.assignment2;

public class VerseAndTranslation {
    public String verse;
    public String translation;

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public VerseAndTranslation(String verse, String translation) {
        this.verse = verse;
        this.translation = translation;
    }
}
