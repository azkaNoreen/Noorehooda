package com.example.noorehuda;

public class PairString {
    public String Verse;
    public String eTrans;
    public String utrans;

    public String getVerse() {
        return Verse;
    }

    public void setVerse(String verse) {
        Verse = verse;
    }

    public String geteTrans() {
        return eTrans;
    }

    public void seteTrans(String eTrans) {
        this.eTrans = eTrans;
    }

    public String getUtrans() {
        return utrans;
    }

    public void setUtrans(String utrans) {
        this.utrans = utrans;
    }

    public PairString(String verse, String eTrans, String utrans) {
        Verse = verse;
        this.eTrans = eTrans;
        this.utrans = utrans;
    }
}
