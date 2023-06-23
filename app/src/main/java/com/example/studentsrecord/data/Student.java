package com.example.studentsrecord.data;

public class Student {

    private String id;
    private String name;
    private int age;
    private int _class;
    private int surah_no;
    private int para_no;
    private int start_verse;
    private int end_verse;
    private int sabqi;
    private int manzil;

    public Student()
    {
        this.id ="S000";
        this.name = "";
        this.age =0;
        this._class=0;
        this.surah_no =0;
        this.para_no =0;
        this.start_verse =0;
        this.end_verse =0;
        this. sabqi =0;
        this.manzil =0;
    }

    public Student( String id,String name, int age, int class_no, int surah_no, int para, int start_verse, int end_verse, int manzil)
    {
        this.id=id;
        this.name = name;
        this.age = age;
        this._class=class_no;
        this.surah_no = surah_no;
        this.para_no=para;
        this.start_verse=start_verse;
        this.end_verse=end_verse;
        this.sabqi= para_no-1;
        this.manzil=manzil;
    }
    // getters and setters

    public void setId(String id)
    {
        this.id=id;
    }

    public String getId()
    {
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    public void setClass(int _class)
    {
        this._class = _class;
    }

    public int get_Class()   {
        return this._class;
    }

    public void setSurah(int _surah)
    {
        this.surah_no = _surah;
    }

    public int getSurah() {
        return this.surah_no;
    }

    public void setPara(int para){
        this.para_no=para;
    }

    public int getPara()
    {
        return this.para_no;
    }

    public void setStartVerse(int start_verse)
    {
        this.start_verse=start_verse;
    }

    public int getStartVerse()
    {
        return this.start_verse;
    }

    public void setEndVerse(int end_verse){
        this.end_verse=end_verse;
    }

    public int getEndVerse()
    {
        return this.end_verse;
    }

    public void setSabqi(int sabqi)
    {
        this.sabqi=sabqi;
    }

    public int getSabqi()
    {
        return this.sabqi;
    }
    public void setManzil(int manzil)
    {
        this.manzil=manzil;
    }

    public int getManzil()
    {
        return this.manzil;
    }
}
