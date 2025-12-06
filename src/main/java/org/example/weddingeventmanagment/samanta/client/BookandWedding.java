package com.midterm_2320481_8.weeding_event_management.samanta.client;

import java.io.Serializable;
import java.time.LocalDate;

public class BookandWedding implements Serializable {
    private String listofVenue;
    private String payment;
    private int capacity;
    private String nenueAva;
    private LocalDate date;

    public BookandWedding(String listofVenue, String payment, int capacity, String nenueAva, LocalDate date) {
        this.listofVenue = listofVenue;
        this.payment = payment;
        this.capacity = capacity;
        this.nenueAva = nenueAva;
        this.date = date;
    }

    public String getListofVenue() {
        return listofVenue;
    }

    public void setListofVenue(String listofVenue) {
        this.listofVenue = listofVenue;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getNenueAva() {
        return nenueAva;
    }

    public void setNenueAva(String nenueAva) {
        this.nenueAva = nenueAva;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookandWedding{" +
                "listofVenue='" + listofVenue + '\'' +
                ", payment='" + payment + '\'' +
                ", capacity=" + capacity +
                ", nenueAva='" + nenueAva + '\'' +
                ", date=" + date +
                '}';
    }
}
