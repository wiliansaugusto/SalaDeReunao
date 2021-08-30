package br.com.digitalinnovatione.saladereuniao.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String messagem;
    private String details;

    public ErrorDetails(Date timestamp, String messagem, String details) {
        super();
        this.timestamp = timestamp;
        this.messagem = messagem;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessagem() {
        return messagem;
    }

    public String getDetails() {
        return details;
    }
}
