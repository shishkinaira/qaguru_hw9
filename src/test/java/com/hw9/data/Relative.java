package com.hw9.data;


public abstract class Relative {
    public static String nameRelative ;
    public static int age;
    public static PositionInFamily positionInFamily;

    public Relative(PositionInFamily positionInFamily) {
        this.positionInFamily = positionInFamily;
    }

    public abstract void getAllRelative();

}
