/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.models;

import java.time.LocalDateTime;

/**
 *
 * @author jdaza
 */
public class Event {

    private static String[] eventTypes
            = new String[]{"Graduation", "Wedding", "Birthday"};
    private static int numberOfUsers = 0;

    private long id;
    private String eventType;
    private int guests;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Event() {
        this.id = ++numberOfUsers;
        this.state = 1;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Event(long id, String eventType, int guests, LocalDateTime startTime,
            LocalDateTime endTime) {
        this.id = id;
        this.eventType = eventType;
        this.guests = guests;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = 1;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static String[] getEventTypes() {
        return eventTypes;
    }

    public static void setEventTypes(String[] eventTypes) {
        Event.eventTypes = eventTypes;
    }

    public static int getNumberOfUsers() {
        return numberOfUsers;
    }

    public static void setNumberOfUsers(int numberOfUsers) {
        Event.numberOfUsers = numberOfUsers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
