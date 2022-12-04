package com.example.scadaproject;

public class Actuadores {

    private boolean Abrir_piso;
    private boolean Banda1;
    private boolean Banda2;
    private boolean Clamp;
    private boolean Elevador_Moviendo;
    private boolean Exit_Conveyor;
    private boolean Load_Pallet;
    private boolean Pallet_Feeder;
    private boolean Push;
    private boolean Rotador;

    public Actuadores() {
        Abrir_piso=false;
        Banda1=false;
        Banda2=false;
        Clamp=false;
        Elevador_Moviendo=false;
        Exit_Conveyor=false;
        Load_Pallet=false;
        Pallet_Feeder=false;
        Push=false;
        Rotador=false;
    }


    public boolean isAbrir_piso() {
        return Abrir_piso;
    }

    public void setAbrir_piso(boolean abrir_piso) {
        Abrir_piso = abrir_piso;
    }

    public boolean isBanda1() {
        return Banda1;
    }

    public void setBanda1(boolean banda1) {
        Banda1 = banda1;
    }

    public boolean isBanda2() {
        return Banda2;
    }

    public void setBanda2(boolean banda2) {
        Banda2 = banda2;
    }

    public boolean isClamp() {
        return Clamp;
    }

    public void setClamp(boolean clamp) {
        Clamp = clamp;
    }

    public boolean isElevador_Moviendo() {
        return Elevador_Moviendo;
    }

    public void setElevador_Moviendo(boolean elevador_Moviendo) {
        Elevador_Moviendo = elevador_Moviendo;
    }

    public boolean isExit_Conveyor() {
        return Exit_Conveyor;
    }

    public void setExit_Conveyor(boolean exit_Conveyor) {
        Exit_Conveyor = exit_Conveyor;
    }

    public boolean isLoad_Pallet() {
        return Load_Pallet;
    }

    public void setLoad_Pallet(boolean load_Pallet) {
        Load_Pallet = load_Pallet;
    }

    public boolean isPallet_Feeder() {
        return Pallet_Feeder;
    }

    public void setPallet_Feeder(boolean pallet_Feeder) {
        Pallet_Feeder = pallet_Feeder;
    }

    public boolean isPush() {
        return Push;
    }

    public void setPush(boolean push) {
        Push = push;
    }

    public boolean isRotador() {
        return Rotador;
    }

    public void setRotador(boolean rotador) {
        Rotador = rotador;
    }
}
