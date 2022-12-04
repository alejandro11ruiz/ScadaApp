package com.example.scadaproject;

public class Sensores {

    private boolean Clamped;
    private boolean Limite_Piso;
    private boolean Pallet_Entry;
    private boolean Pallet_Loaded;
    private boolean Pusher_Limit;
    private boolean Sensor_Cajas;

    public Sensores(){
        Clamped=false;
        Limite_Piso=false;
        Pallet_Entry=false;
        Pallet_Loaded=false;
        Pusher_Limit=false;
        Sensor_Cajas=false;
    }

    public boolean isClamped() {
        return Clamped;
    }

    public void setClamped(boolean clamped) {
        Clamped = clamped;
    }

    public boolean isLimite_Piso() {
        return Limite_Piso;
    }

    public void setLimite_Piso(boolean limite_Piso) {
        Limite_Piso = limite_Piso;
    }

    public boolean isPallet_Entry() {
        return Pallet_Entry;
    }

    public void setPallet_Entry(boolean pallet_Entry) {
        Pallet_Entry = pallet_Entry;
    }

    public boolean isPallet_Loaded() {
        return Pallet_Loaded;
    }

    public void setPallet_Loaded(boolean pallet_Loaded) {
        Pallet_Loaded = pallet_Loaded;
    }

    public boolean isPusher_Limit() {
        return Pusher_Limit;
    }

    public void setPusher_Limit(boolean pusher_Limit) {
        Pusher_Limit = pusher_Limit;
    }

    public boolean isSensor_Cajas() {
        return Sensor_Cajas;
    }

    public void setSensor_Cajas(boolean sensor_Cajas) {
        Sensor_Cajas = sensor_Cajas;
    }
}
