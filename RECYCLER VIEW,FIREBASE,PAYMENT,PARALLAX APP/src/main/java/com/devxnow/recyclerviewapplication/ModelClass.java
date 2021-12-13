package com.devxnow.recyclerviewapplication;

        import java.io.Serializable;

public class ModelClass implements Serializable {
    //You need to use a constructor
    //Shortcut keys to get a constructor (ALT+FN+INS) or (ALT+INS)
    String personName,personaText,personTime;
    int personDp;

    public ModelClass(String personName, String personaText, String personTime, int personDp) {
        this.personName = personName;
        this.personaText = personaText;
        this.personTime = personTime;
        this.personDp = personDp;
    }
}
