package com.hw9;
import com.hw9.data.*;

public class Main {
    public static void main (String[] args){
        Relative dedushka = new GrandFatherRelative();
        GrandFatherRelative.nameRelative = "Ded Ivan";
        GrandFatherRelative.age = 80;
        GrandFatherRelative.positionInFamily = PositionInFamily.GRANDFATHER;
//        Relative babushka = new GrandMatherRelative("Baba Mania", 78, GRANDMOTHER);
//        Relative mama = new MatherRelative("Mama Tania", 40, MOTHER);
//        Relative papa = new FatherRelative("Papa Tolia", 45, FATHER);
//        Relative sin = new SonRelative("Sin Dania", 15, GRANDSON);
//        Relative doch1 = new DoughterRelative("Doch Katia", 10, GRANDDAUGHTER);
//        Relative doch2 = new DoughterRelative("Doch Masha", 5, GRANDDAUGHTER);
//
        dedushka.getAllRelative();
//        babushka.getAllRelative();
//        mama.getAllRelative();
//        papa.getAllRelative();
//        sin.getAllRelative();
//        doch1.getAllRelative();
//        doch2.getAllRelative();
    }


}
