package com.example.jenison_3631.realmtest;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jenison-3631 on 15/06/17.
 */

public class AnimalObject extends RealmObject {
    @PrimaryKey
    private Integer animalName;


    public Integer getAnimalName(){
        return animalName;
    }
    public void setAnimalName(Integer name){
        animalName=name;
    }

    private Integer animalType1;
    private Integer animalType2;
    private Integer animalType3;
    private Integer animalType4;
    private Integer animalType5;
    private Integer animalType6;
    private Integer animalType7;
    private Integer animalType8;
    private Integer animalType9;
    private Integer animalType10;

    public Integer getAnimalType1(){
        return animalType1;
    }
    public Integer getAnimalType2(){
        return animalType2;
    }
    public Integer getAnimalType3(){
        return animalType3;
    }
    public Integer getAnimalType4(){
        return animalType4;
    }
    public Integer getAnimalType5(){
        return animalType5;
    }
    public Integer getAnimalType6(){
        return animalType6;
    }
    public Integer getAnimalType7(){
        return animalType7;
    }
    public Integer getAnimalType8(){
        return animalType8;
    }
    public Integer getAnimalType9(){
        return animalType9;
    }
    public Integer getAnimalType10(){
        return animalType10;
    }

    public void setAnimalType1(Integer type){
        animalType1=type;
    }
    public void setAnimalType2(Integer type){
        animalType2=type;
    }
    public void setAnimalType3(Integer type){
        animalType3=type;
    }
    public void setAnimalType4(Integer type){
        animalType4=type;
    }
    public void setAnimalType5(Integer type){
        animalType5=type;
    }
    public void setAnimalType6(Integer type){
        animalType6=type;
    }
    public void setAnimalType7(Integer type){
        animalType7=type;
    }
    public void setAnimalType8(Integer type){
        animalType8=type;
    }
    public void setAnimalType9(Integer type){
        animalType9=type;
    }
    public void setAnimalType10(Integer type){
        animalType10=type;
    }




}
