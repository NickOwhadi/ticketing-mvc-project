package com.nicko.ticketingmvcproject.enums;

public enum Status {
    OPEN("Open"),IN_PROGRESS("In_Progress"),COMPLETE("Completed");

  private final String value;


    private Status(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
