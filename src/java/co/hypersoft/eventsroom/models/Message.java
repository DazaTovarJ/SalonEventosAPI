/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.models;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jdaza
 */
@XmlRootElement
public class Message {

    private int code;
    private String message;
    private String additionalInfo;
    private Object data;

    public Message() {
    }

    public Message(int code, String message, String additionalInfo) {
        this.code = code;
        this.message = message;
        this.additionalInfo = additionalInfo;
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Message(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Message(int code, String message, String additionalInfo, Object data) {
        this.code = code;
        this.message = message;
        this.additionalInfo = additionalInfo;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

}
