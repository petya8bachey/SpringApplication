package org.petya8bachey.controller;

public class MyPacket<T> {
    public boolean hasError;
    public String description;
    public T data;

    public MyPacket (T data){
        this.data = data;
        hasError = false;
    }
    public MyPacket(T data, String description) {
        this.data = data;
        this.description = description;
        hasError = true;
    }

}
