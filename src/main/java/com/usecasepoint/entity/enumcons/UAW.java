package com.usecasepoint.entity.enumcons;

import java.util.Arrays;
import java.util.List;

public enum UAW {
    SIMPLE("simple", "Aktor pada use case berinteraksi dengan API atau Command Prompt", 1),
    AVERAGE("average", "Aktor berinteraksi melalui protokol, seperti TCP/IP", 2),
    COMPLEX("complex","Aktor yang berasumsi sebagai Manusia/Orang",3);

    private String type;
    private String description;
    private Integer weightFactor;

    UAW(String type, String description, Integer weightFactor) {
        this.type = type;
        this.description = description;
        this.weightFactor = weightFactor;
    }

    public List<String> UAWList(){
        return Arrays.asList(SIMPLE.type, AVERAGE.type, COMPLEX.type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeightFactor() {
        return weightFactor;
    }

    public void setWeightFactor(Integer weightFactor) {
        this.weightFactor = weightFactor;
    }
}
