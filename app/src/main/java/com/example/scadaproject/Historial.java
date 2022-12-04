package com.example.scadaproject;

import java.util.ArrayList;

public class Historial {

    private ArrayList<String> date;
    private ArrayList<Boolean> value;

    public Historial(){
        date=new ArrayList<>();
        value=new ArrayList<>();
    }

    public ArrayList<String> getDate() {
        return date;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }

    public ArrayList<Boolean> getValue() {
        return value;
    }

    public void setValue(ArrayList<Boolean> value) {
        this.value = value;
    }

    public void filtrar(){
        ArrayList<String> dateAux = new ArrayList<>();
        ArrayList<Boolean> valueAux = new ArrayList<>();
        if(this.value.size()>0){
            valueAux.add(this.value.get(0));
            dateAux.add(this.date.get(0));
            for(int i=1; i<this.value.size(); i++){
                if(!this.value.get(i-1).equals(this.value.get(i))){
                    valueAux.add(this.value.get(i));
                    dateAux.add(this.date.get(i));
                }
            }
            this.setValue(valueAux);
            this.setDate(dateAux);
        }
    }

}
